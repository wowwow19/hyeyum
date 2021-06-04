package com.hyeyum.service;

import com.hyeyum.domain.ProfessorVO;

/**
 * 교수 강의개설관리와 관련된 서비스의 기능을 정의하는 인터페이스
 * @author 오승현
 * @since 2021 / 05 / 20
 *
 */

public interface ProferssorInfoService {

	
	ProfessorVO getProInfo(String profno); // 인적 사항 조회
	
	int updateProfInfo(ProfessorVO professorVO); // 인적 사항 수정
}
