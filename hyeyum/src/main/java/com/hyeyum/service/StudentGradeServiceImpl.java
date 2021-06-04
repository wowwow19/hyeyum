package com.hyeyum.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyeyum.domain.CorrectionCategory;
import com.hyeyum.domain.CorrectionVO;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.domain.Credit;
import com.hyeyum.domain.CurriculumVO;
import com.hyeyum.domain.SugangVO;
import com.hyeyum.mapper.CorrectionMapper;
import com.hyeyum.mapper.SugangMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * StudentGradeService를 구현한 클래스
 * @author 이찬희
 * @since 21/05/20
 */
@Service
@Log4j
@AllArgsConstructor
public class StudentGradeServiceImpl implements StudentGradeService{
	private SugangMapper sugangMapper;
	private CorrectionMapper correctionMapper;
	
	/**
	 * 특정 학생의 수강완료 내역을 바탕으로 이수구분별 이수학점을 조회하는 메서드
	 * @author 전민우
	 */
	@Override
	public Credit getCredit(Long studno) {
		log.info("getCredit...");
		
		Credit credit = new Credit();
		List<SugangVO> sugangList = sugangMapper.getListWithCurriculum(studno);
		
		for(CurriculumVO vo : sugangList) {
			if(vo.getCategory() == null) {
				credit.setOthers(credit.getOthers() + vo.getCredit());
			} else if(vo.getCategory().equals("전공필수")) {
				credit.setContexts(credit.getContexts() + vo.getCredit());
			} else {
				credit.setElectives(credit.getElectives() + vo.getCredit());
			}
		}
		
		return credit;
	}
	
	/**
	 * 단일 성적 이의신청내역을 상세조회하는 메서드
	 * @author 이찬희
	 */
	@Override
	public CorrectionVO getCorrection(Long corrno) {
		log.info("getCorrection...");	
		return correctionMapper.get(corrno);
	}
	
	/**
	 * 특정 카테고리에 해당하는 성적 이의신청의 목록을 조회하는 메서드
	 * @author 이찬희
	 */
	@Override
	public List<CorrectionVO> getCorrectionList(CorrectionCategory category) {
		log.info("getCorrectionList...");
		return correctionMapper.getList(category);
	}
	
	/**
	 * 이의신청내역에 이의신청 정보를 입력하는 메서드
	 * @author 전민우
	 */
	@Override
	@Transactional
	public int requestCorrection(CorrectionVO correctionVO) {
		log.info("requestCorrection...");
		
		CorrectionCategory category = new CorrectionCategory();
		category.setStudno(correctionVO.getStudno());
		category.setCoursno(correctionVO.getCoursno());
		category.setStatus(false);
		
		List<CorrectionVO> list = correctionMapper.getList(category);
		list.forEach(log::info);
		SugangVO sugangVO = sugangMapper.read(correctionVO.getStudno(), correctionVO.getCoursno());
		
		// 동일한 과목에 대한 이의신청을 중복하여 신청하는경우
		if(list.size() != 0) {
			return -1;
		}
		
		log.info("PASS!");
		// 수강하지 않은 과목에 대한 이의신청을 하는 경우
		// 성적이 입력되지 않은 과목에 대한 이의신청을 하는 경우
		if(sugangVO == null || sugangVO.getResult() == null) {
			return -1;
		}
		
		return correctionMapper.insert(correctionVO);
	}
	
	/**
	 * 특정 이의신청내역을 삭제하는 메서드
	 * @author 전민우
	 */
	@Override
	public int cancleCorrection(CorrectionVO correctionVO) {
		log.info("cancleCorrection...");
		
		correctionVO = getCorrection(correctionVO.getCorrno());
		// 이미 처리완료된 이의신청을 취소하려고 하는 경우
		if(correctionVO.getCorrStatus() == 1) return -1;
		
		return correctionMapper.delete(correctionVO);
	}
	
	/**
	 * 특정 학생의 수강이력의 목록을 조회하는 메서드
	 * @author 이찬희
	 */
	@Override
	public List<SugangVO> getList(Long studno) {
		log.info("list...");
		return sugangMapper.getListWithCurriculum(studno);
	}
}
