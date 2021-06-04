package com.hyeyum.service;

import com.hyeyum.domain.StudentVO;

/**
 * 학생 신상정보와 관련된 서비스의 기능을 정의하는 인터페이스
 * @author 전민우
 * @since 21/05/20
 */
public interface StudentInfoService {
	
	/**
	 * 학번을 이용하여 단일 학생의 데이터를 조회하는 메서드
	 * @author 전민우
	 */
	StudentVO get(Long studno);
	
	/**
	 * 학생의 신상정보 및 비밀번호를 수정하는 메서드
	 * @author 전민우
	 */
	int update(StudentVO studentVO);
}
