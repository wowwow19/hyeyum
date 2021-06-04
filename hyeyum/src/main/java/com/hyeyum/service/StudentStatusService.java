package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.StatusCategory;
import com.hyeyum.domain.StudStatusVO;

/**
 * 학생의 학적변동과 관련된 서비스의 기능을 정의하는 인터페이스
 * @author 이찬희
 * @since 21/05/20
 */
public interface StudentStatusService {
	
	/**
	 * 특정 학적변동내역을 상세조회하는 메서드
	 * @author 이찬희
	 */
	StudStatusVO get(Long statusno);
	
	/**
	 * 특정 카테고리에 해당하는 학적변동내역의 목록을 조회하는 메서드
	 * @author 이찬희
	 */
	List<StudStatusVO> getList(StatusCategory category);
	
	/**
	 * 학적변동 신청사항을 입력하는 메서드
	 * @author 전민우
	 */
	int insert(StudStatusVO studStatusVO);
	
	/**
	 * 학적변동 신청사항을 삭제하는 메서드
	 * @author 전민우
	 */
	int delete(StudStatusVO studStatusVO);
}
