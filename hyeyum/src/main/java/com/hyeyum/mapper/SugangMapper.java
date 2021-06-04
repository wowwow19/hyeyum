package com.hyeyum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CurriculumVO;
import com.hyeyum.domain.SugangVO;

/**
 * 수강신청내역 테이블의 데이터를 조작하는 매퍼 인터페이스
 * @author 전민우
 * @since 21/05/20
 */
public interface SugangMapper {
	
	/**
	 * 단일 수강신청 내역의 상세정보를 조회하는 메서드
	 * @author 전민우
	 */
	SugangVO read(@Param("studno") Long studno, @Param("coursno") Long coursno);
	
	/**
	 * 특정 학생의 수강신청내역의 목록을 조회하는 메서드
	 * @author 전민우
	 */
	List<SugangVO> getList(@Param("studno") Long studno);
	
	/**
	 * 특정 학생의 확정된 수강신청내역의 목록을 조회하는 메서드
	 * @author 전민우
	 */
	List<SugangVO> getConfirmedList(@Param("studno") Long studno);
	
	/**
	 * 특정 학생의 수강신청내역의 커리큘럼 목록을 조회하는 메서드
	 * @author 전민우
	 */
	List<SugangVO> getListWithCurriculum(Long studno);
	
	/**
	 * 특정 강의의 수강인원을 조회하는 메서드
	 * @author 전민우
	 */
	int getSugangNum(Long coursno);
	
	/**
	 * 수강신청내역을 추가하는 메서드
	 * @author 전민우
	 */
	int insert(SugangVO sugangVO);
	
	/**
	 * 수강신청내역의 상태를 변경하는 메서드(수강신청내역 확정)
	 * @author 전민우
	 */
	int update(SugangVO sugangVO);
	
	/**
	 * 특정 수강신청내역을 삭제하는 메서드(조건 : 신청완료되지 않은 상태여야 함)
	 * @author 전민우
	 */
	@Delete("DELETE FROM TBL_SUGANG WHERE STUDNO = #{studno} AND COURSNO = #{coursno}")
	int delete(SugangVO sugangVO);
	
	/**
	 * 휴학시 기존의 수강신청 내역을 삭제하는 메서드(조건 : 성적이 산정되지 않은 상태여야 함)
	 */
	@Delete("DELETE FROM TBL_SUGANG WHERE STUDNO = #{studno} AND RESULT IS NULL")
	int deleteAll(Long studno);
	
	/**
	 * 특정 강의에 대한 수강정보 목록을 조회하는 메서드
	 * @author 전민우
	 */
	List<SugangVO> getListByCoursno(Long coursno);
}
