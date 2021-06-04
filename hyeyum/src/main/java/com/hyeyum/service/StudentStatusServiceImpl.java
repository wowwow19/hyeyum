package com.hyeyum.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyeyum.domain.StatusCategory;
import com.hyeyum.domain.StudStatusVO;
import com.hyeyum.domain.StudentVO;
import com.hyeyum.mapper.StudStatusMapper;
import com.hyeyum.mapper.StudentMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * StudentStatusService를 구현한 클래스
 * @author 이찬희
 * @since 21/05/20
 */
@Service
@AllArgsConstructor
@Log4j
public class StudentStatusServiceImpl implements StudentStatusService {
	private StudStatusMapper studStatusMapper;
	private StudentMapper studentMapper;
	
	/**
	 * 특정 학적변동내역을 상세조회하는 메서드
	 * @author 이찬희
	 */
	@Override
	public StudStatusVO get(Long statusno) {
		log.info("get...");
		return studStatusMapper.read(statusno);
	}
	
	/**
	 * 특정 카테고리에 해당하는 학적변동내역의 목록을 조회하는 메서드
	 * @author 이찬희
	 */
	@Override
	public List<StudStatusVO> getList(StatusCategory category) {
		log.info("getList...");
		
		return studStatusMapper.getList(category);
	}
	
	/**
	 * 학적변동 신청사항을 입력하는 메서드
	 * @author 전민우
	 */
	@Override
	@Transactional
	public int insert(StudStatusVO studStatusVO) {
		log.info("insert...");
		
		StatusCategory category = new StatusCategory();
		category.setStudno(studStatusVO.getStudno());
		
		List<StudStatusVO> list = getList(category);
		StudentVO studentVO = studentMapper.read(studStatusVO.getStudno());
		
		// 현재 학적상태와 동일하게 신청하려할 때
		if(studentVO.getStatus() == studStatusVO.getChange()) return -1;
		
		if(list != null) {
			for(StudStatusVO vo : list) {
				// 처리되지 않은 학적 변동 사항이 있을 때
				if(!vo.getReStatus()) {
					return -1;
				}
			}			
		}
		
		return studStatusMapper.insert(studStatusVO);
	}

	/**
	 * 학적변동 신청사항을 삭제하는 메서드
	 * @author 전민우
	 */
	@Override
	@Transactional
	public int delete(StudStatusVO studStatusVO) {
		log.info("delete...");
		
		studStatusVO = studStatusMapper.read(studStatusVO.getStatusno());
		
		// 이미 처리완료된 신청내역을 취소하려할 때
		if(studStatusVO.getReStatus()) {
			return -1;
		}
		
		return studStatusMapper.delete(studStatusVO);
	}

}
