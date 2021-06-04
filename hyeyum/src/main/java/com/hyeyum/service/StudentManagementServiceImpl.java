package com.hyeyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyeyum.domain.CorrectionCategory;
import com.hyeyum.domain.CorrectionVO;
import com.hyeyum.domain.CounselVO;
import com.hyeyum.domain.StudentCategory;
import com.hyeyum.domain.StudentVO;
import com.hyeyum.domain.SugangVO;
import com.hyeyum.mapper.CorrectionMapper;
import com.hyeyum.mapper.CounselMapper;
import com.hyeyum.mapper.StudentMapper;
import com.hyeyum.mapper.SugangMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * StudetnManagementService를 구현한 클래스
 * @author 오승현
 * @since 21 / 05 / 21
 */


@Service
@AllArgsConstructor
@Log4j
public class StudentManagementServiceImpl implements StudentManagementService{
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private CounselMapper counselMapper;
	@Autowired
	private CorrectionMapper correctionMapper;
	@Autowired
	private SugangMapper sugangMapper;

	@Override
	public List<StudentVO> getCouInfo(StudentCategory category) {
		log.info("getCouInfo........");
		return studentMapper.getList(category);
	}

	@Override
	public int getwriCounsel(CounselVO counselVO) {
		log.info("getwriCounsel......");
		return counselMapper.insert(counselVO);
	}

	@Override
	public int insertGrade(SugangVO sugangVO) {
		log.info("insertGrade....");
		return sugangMapper.update(sugangVO);
	}

	@Override
	public List<CorrectionVO> getCorrectionList(CorrectionCategory category) {
		log.info("getCorrectionList......");
		return correctionMapper.getList(category);
	}

	@Override
	public CorrectionVO getCorrection(Long corrno) {
		log.info("getCorrection......");
		return correctionMapper.get(corrno);
	}

	@Override
	@Transactional
	public int updateGrade(SugangVO sugangVO, CorrectionVO correctionVO) {
		log.info("updateGrade");
	 	 int corCnt = correctionMapper.update(correctionVO);
		sugangMapper.update(sugangVO);
		return corCnt;
	}

//	@Override
//	public CounselVO getCounsel(Long studno) {
//		log.info("getCounsel...");
//		return getCounsel(studno);
//	}

	@Override
	public List<CounselVO> getCounselList(Long studno) {
		log.info("get Counsel List...");
		return counselMapper.getList(studno);
	}

	@Override
	public SugangVO getSugang(Long studno, Long coursno) {
		log.info("getSugang....");
		
		return sugangMapper.read(studno, coursno);
	}

	@Override
	public List<SugangVO> getSugangList(Long coursno) {
		log.info("getSugangList....");
		return sugangMapper.getListByCoursno(coursno);
	}

	
}
