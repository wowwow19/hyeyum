package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;

// 강의 정보 , 강의 조회
/**
 * 교수 개인신상정보관리와 관련된 서비스의 기능을 정의하는 인터페이스
 * @author 오승현
 * @since 2021 / 05 / 20
 *
 */
public interface ProferssorCourseService {

	int addCourse(CourseVO courseVO);
	
	CourseVO getCouInfo(CourseCategory category);
	
	List<CourseVO> getList(CourseCategory category);
	
	Long getCurrentNo(Long deptno);
	
	List<String> getLocationList(Long deptno);
}
