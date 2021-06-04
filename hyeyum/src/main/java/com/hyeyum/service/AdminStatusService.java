package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.StatusCategory;
import com.hyeyum.domain.StudStatusVO;

/**
 * 학적 변동 관리 서비스 인터페이스 
 * @author 박수연
 * @since 2021-05-20
 */ 

public interface AdminStatusService { 
	
	/**
	 * 학적변동 신청 목록 조회하는 메서드 
	 * @author 박수연
	 */
	List<StudStatusVO> getStatusList(StatusCategory category);
	
	/**
	 * 학적변동 신청 상세내역 조회하는 메서드 
	 * @author 강영훈
	 */
	StudStatusVO getStatus(Long statusno);
	
	/**
	 * 학적변동 승인 처리하는 메서드 
	 * @author 강영훈
	 */
	int updateStatus(StudStatusVO studStatusVO);

}
