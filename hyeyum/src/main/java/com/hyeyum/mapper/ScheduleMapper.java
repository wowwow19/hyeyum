package com.hyeyum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.hyeyum.domain.ScheduleCategory;
import com.hyeyum.domain.ScheduleVO;

/**
 * 학사일정(ScheduleVO) 클래스와 관련된 테이블의 데이터를 조작하는 매퍼 인터페이스
 * @author 전민우
 * @since 2021/05/28
 */
public interface ScheduleMapper {
	/**
	 * 특정 학사일정의 상세정보를 조회하는 메서드
	 * @author 전민우
	 */
	ScheduleVO read(Long scheno);
	
	/**
	 * 카테고리별 학사일정의 목록을 조회하는 메서드
	 * @author 전민우
	 */
	List<ScheduleVO> getList(ScheduleCategory category);
	
	/**
	 * 학사일정 정보를 입력하는 메서드
	 * @author 전민우
	 */
	int insert(ScheduleVO scheduleVO);
	
	/**
	 * 학사일정 정보를 수정하는 메서드
	 * @author 전민우
	 */
	int update(ScheduleVO scheduleVO);
	
	/**
	 * 학사일정 정보를 삭제하는 메서드
	 * @author 전민우
	 */
	@Delete("DELETE FROM TBL_SCHEDULE WHERE SCHENO = #{scheno}")
	int delete(ScheduleVO scheduleVO);
}
