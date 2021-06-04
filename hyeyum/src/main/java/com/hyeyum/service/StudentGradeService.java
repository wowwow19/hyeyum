package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.CorrectionCategory;
import com.hyeyum.domain.CorrectionVO;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.domain.Credit;
import com.hyeyum.domain.CurriculumVO;
import com.hyeyum.domain.SugangVO;

/**
 * 학생의 성적과 관련된 서비스의 기능을 정의하는 인터페이스
 * @author 이찬희
 * @since 21/05/20
 */
public interface StudentGradeService {
	
	/**
	 * 특정 학생의 수강완료 내역을 바탕으로 이수구분별 이수학점을 조회하는 메서드
	 * @author 전민우
	 */
	Credit getCredit(Long studno);
	
	/**
	 * 특정 카테고리에 해당하는 성적 이의신청의 목록을 조회하는 메서드
	 * @author 이찬희
	 */
	List<CorrectionVO> getCorrectionList(CorrectionCategory category);
	
	/**
	 * 단일 성적 이의신청내역을 상세조회하는 메서드
	 * @author 이찬희
	 */
	CorrectionVO getCorrection(Long corrno);
	
	/**
	 * 이의신청내역에 이의신청 정보를 입력하는 메서드
	 * @author 전민우
	 */
	int requestCorrection(CorrectionVO correctionVO);
	
	/**
	 * 특정 이의신청내역을 삭제하는 메서드
	 * @author 전민우
	 */
	int cancleCorrection(CorrectionVO correctionVO);
	
	/**
	 * 특정 학생의 수강이력의 목록을 조회하는 메서드
	 * @author 이찬희
	 */
	List<SugangVO> getList(Long studno);
}
