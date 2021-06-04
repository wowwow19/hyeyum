package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.MemberVO;
import com.hyeyum.domain.ScheduleCategory;
import com.hyeyum.domain.ScheduleVO;

/**
 * 공통된 서비스의 기능을 정의하는 인터페이스
 * @author 전민우
 * @since 21/05/28
 */
public interface CommonService {
	/**
	 * 특정 학사일정을 상세조회하는 메서드
	 * @author 전민우
	 */
	ScheduleVO getSchedule(Long scheno);
	
	/**
	 * 카테고리에 해당하는 특정 학사일정 목록을 조회하는 메서드
	 * @author 전민우
	 */
	List<ScheduleVO> getScheduleList(ScheduleCategory category);
	
	/**
	 * 학사일정을 추가하는 메서드
	 * @author 전민우
	 */
	int insertSchedule(ScheduleVO scheduleVO);
	
	/**
	 * 학사일정을 수정하는 메서드
	 * @author 전민우
	 */
	int updateSchedule(ScheduleVO scheduleVO);
	
	/**
	 * 학사일정을 삭제하는 메서드
	 * @author 전민우
	 */
	int deleteSchedule(ScheduleVO scheduleVO);
	
	/**
	 * 학생 및 교수 계정의 비밀번호를 변경하는 메서드
	 * @author 전민우
	 */
	int updateAccount(MemberVO memberVO);
}
