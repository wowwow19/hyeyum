package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.CurriculumVO;


/**
 * 교육과정 관리 서비스 인터페이스 
 * @author 강영훈
 * @since 2021-05-20
 */
public interface AdminCurriculumService {
	
	/**
	 * 교육과정을 조회하는 메서드 
	 * @author 강영훈
	 */
	List<CurriculumVO> getList(); 
	
	/**
	 * 교육과정을 상세 조회하는 메서드 
	 * @author 강영훈
	 */
	CurriculumVO get(String coursno);
	
	/**
	 * 교육과정 추가하는 메서드 
	 * @author 강영훈
	 */
	int addCurriculum(CurriculumVO curriculumVO);
	
	/**
	 * 교육과정을 수정하는 메서드 
	 * @author 박수연
	 */
	int updateCurriculum(CurriculumVO curriculumVO); 
	
	/**
	 * 교육과정을 삭제하는 메서드 
	 * @author 박수연
	 */
	int deleteCurriculum(String coursno); 
}
