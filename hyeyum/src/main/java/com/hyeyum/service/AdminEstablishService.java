package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;

/** 
 * 강의 개설 신청관리 서비스 인터페이스 
 * @author 강영훈
 * @since 2021-05-20
 */
public interface AdminEstablishService {
	
	/**
	 * 강의 목록 조회하는 메서드 
	 * @author 박수연
	 */
	List<CourseVO> getList(CourseCategory category);
	
	/**
	 * 강의 조회하는 메서드 
	 * @author 박수연
	 */
	CourseVO getCourse(CourseCategory category);
	
	/** 
	 * 강의 승인 처리하는 메서드 
	 * @author 강영훈
	 */
	int approveCourse(CourseVO courseVO);
}
