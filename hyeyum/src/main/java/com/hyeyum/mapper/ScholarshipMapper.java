package com.hyeyum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.hyeyum.domain.ScholarshipVO;

/**
 * 장학금 지급내역(ScholarshipVO) 클래스와 관련된 테이블의 데이터를 조작하는 매퍼 인터페이스
 * @author 전민우
 * @since 2021/05/19
 */
public interface ScholarshipMapper {
	
	/**
	 * 특정 장학금 지급내역의 상세정보를 조회하는 메서드
	 * @author 전민우
	 */
	ScholarshipVO read(Long schono);
	
	/**
	 * 카테고리별 지급내역의 목록을 조회하는 메서드
	 * @author 전민우
	 */
	List<ScholarshipVO> getList(@Param("deptno") Long deptno, @Param("studno") Long studno);
	
	/**
	 * 등록금 지급내역을 내역 목록에 추가하는 메서드
	 * @author 전민우
	 */
	int insert(ScholarshipVO scholarshipVO);
	
	/**
	 * 특정 학생의 장학금 지급내역을 일괄적으로 삭제하는 메서드
	 * @author 전민우
	 */
	@Delete("DELETE FROM TBL_SCHOLARSHIP WHERE STUDNO = #{studno}")
	int delete(Long studno);
}
