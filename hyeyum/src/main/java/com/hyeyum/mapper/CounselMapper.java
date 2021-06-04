package com.hyeyum.mapper;

import java.util.List;

import com.hyeyum.domain.CounselVO;

/**
 * 상담 정보의 데이터 관리를 위한 mapper 인터페이스 메서드 시그니처 정의
 * @author 오승현
 * @since 2021 / 05 /19
 *
 */
public interface CounselMapper {
	
	List<CounselVO> getList(Long studno);
	
	CounselVO read(Long counno);
	
	int insert(CounselVO counselVO);
	
	int update(CounselVO counselVO);
	
	int delete(String counno);

}
