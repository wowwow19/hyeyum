package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.CourseAttachVO;
import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;


/**
 * 강의 관리 서비스 인터페이스 
 * @author 강영훈
 * @since 2021-05-20
 */
public interface AdminCourseService {
	
	/**
	 * 개설된 강의 목록을 조회하는 메서드 
	 * @author 강영훈
	 */
	List<CourseVO> getCourseList(CourseCategory category);
	
	/**
	 * 개설된 강의 상세 조회하는 메서드 
	 * @author 강영훈
	 */
	CourseVO getCourse(CourseCategory category);
	
	/**
	 * 강의 정보 수정하는 메서드 
	 * @author 박수연
	 */
	int updateCourse(CourseVO courseVO);
	
	/**
	 * 강의 삭제하는 메서드 
	 * @author 박수연
	 */
	int deleteCourse(String coursno);
	
	/**
	 * 강의의 강의계획서 목록을 가져오는 메서드
	 * @author 전민우
	 */
	List<CourseAttachVO> getAttachList(Long coursno);
}
