package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.CorrectionCategory;
import com.hyeyum.domain.CorrectionVO;
import com.hyeyum.domain.CounselVO;
import com.hyeyum.domain.StudentCategory;
import com.hyeyum.domain.StudentVO;
import com.hyeyum.domain.SugangVO;

/**
 * 교수읙 학생관리와 관련된 서비스의 기능을 정의하는 인터페이스
 * @author 오승현
 * @since 2021 / 05 / 20
 *
 */
public interface StudentManagementService {
	
	List<StudentVO> getCouInfo(StudentCategory category);
	
	List<CounselVO> getCounselList(Long studno);
	
	//CounselVO getCounsel(Long studno);
	
	
	/**
	 * 교수가 상담내용을 입력하는 메서드
	 * @author 오승현
	 */
	int getwriCounsel(CounselVO counselVO); 
	
	/**
	 * 교수가 성적을 입력하는 메서드 
	 * @author 오승현
	 */
	int insertGrade(SugangVO sugangVO); 
	
	List<CorrectionVO> getCorrectionList(CorrectionCategory category); 
	
	List<SugangVO> getSugangList(Long coursno);
	
	SugangVO getSugang(Long studno, Long coursno);
	/**
	 * 학생들의 성적 이의신청을 조회하는 메서드 
	 * @author 오승현
	 */
	CorrectionVO getCorrection(Long corrno); 
	
	/**
	 * 학생들의 성적 이의신청을 확인후 수정또는 무시하는 메서드 
	 * @author 오승현
	 */
	int updateGrade(SugangVO sugangVO, CorrectionVO correctionVO);
	
}
