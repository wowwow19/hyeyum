package com.hyeyum.mapper;

import java.util.List;

import com.hyeyum.domain.CurriculumVO;

/**
 * 
 * 교육과정 정보의 데이터 관리를 위한 mapper 인터페이스
 * @author 박수연
 * @since 2021/05/17
 */

public interface CurriculumMapper {
	
	List<CurriculumVO> getList();
	
	CurriculumVO read(String coursno);
	
	int insert(CurriculumVO curriculumVO); 
	
	int update(CurriculumVO curriculumVO);
	
	int delete(String coursno);
}
