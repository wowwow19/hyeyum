package com.hyeyum.mapper;

import java.util.List;

import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;

/**
 * 
 * 강의 정보의 데이터 관리를 위한 mapper 인터페이스 메서드 시그니처 정의
 * @author 강영훈
 * @since 2021/05/17
 */
public interface CourseMapper {
	
	List<CourseVO> getList(CourseCategory category); //강의 목록조회

	CourseVO read(CourseCategory category);//강의 상세조회
	
	int insert(CourseVO courseVO); //강의 삽입
	
	int update(CourseVO courseVO); //강의 수정
	
	int delete(String coursno); //강의 삭제
	
	int enable(CourseVO courseVO); //강의 개설 신청 승인처리 
	
	int getCnt(); // 미승인 강의 개수
	
	Long getCurrentNo(Long deptno);
	
	List<String> getLocationList(Long deptno);
}
