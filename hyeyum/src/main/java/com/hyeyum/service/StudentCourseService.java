package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.domain.StudentVO;
import com.hyeyum.domain.SugangVO;

/**
 * 학생의 수강신청과 관련된 서비스의 기능을 정의하는 인터페이스
 * @author 이찬희
 * @since 21/05/20
 */
public interface StudentCourseService {
	
	/**
	 * 특정 카테고리에 해당하는 개설된 강의 목록을 조회하는 메서드
	 * @author 이찬희
	 */
	List<CourseVO> getCourseList(CourseCategory category);//개설강의조회
	
	/**
	 * 특정 카테고리에 해당하는 단일 강의를 상세조회하는 메서드
	 * @author 이찬희
	 */
	CourseVO get(CourseCategory category); //개설강의 상세조회
	
	/**
	 * 특정 학생의 수강신청 및 장바구니 목록에 대한 시간표를 조회하는 메서드
	 * @author 전민우
	 */
	CourseVO[][] getTimeTable(Long studno, Boolean status); //시간표 조회
	
	/**
	 * 장바구니 목록의 특정 수강신청 항목을 상세조회하는 메서드
	 * @author 전민우
	 */
	SugangVO getSugang(Long studno, Long coursno);
	
	/**
	 * 특정 학생의 수강신청 장바구니 목록을 일괄적으로 조회하는 메서드
	 * @author 전민우
	 */
	List<SugangVO> getSugangList(Long studno);//수강내역 조회
	
	/**
	 * 특정 학생의 확정된 수강신청 목록을 일괄적으로 조회하는 메서드
	 * @author 전민우 
	 */
	List<SugangVO> getConfirmedSugangList(Long studno);
	
	/**
	 * 수강신청 장바구니 목록에 강의를 추가하는 메서드
	 * @author 전민우
	 */
	int addSugang(SugangVO sugangVO);
	
	/**
	 * 수강신청 장바구니 목록에서 특정 강의를 삭제하는 메서드
	 * @author 전민우
	 */
	int deleteSugang(SugangVO sugangVO);
	
	/**
	 * 수강신청 장바구니 내역을 확정하는 메서드
	 * @author 전민우
	 */
	int completeSugang(Long studno);
}
