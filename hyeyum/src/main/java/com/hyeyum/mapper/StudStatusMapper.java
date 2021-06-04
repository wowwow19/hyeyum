package com.hyeyum.mapper;

import java.util.List;

import com.hyeyum.domain.StatusCategory;
import com.hyeyum.domain.StudStatusVO;

/**
 * 학적변동(StudStatusVO) 클래스와 관련된 테이블의 데이터를 조작하는 매퍼 인터페이스
 * @author 강영훈
 * @since 2021/05/19
 */

public interface StudStatusMapper {
	
	List<StudStatusVO> getList(StatusCategory category); //목록 조회
	
	StudStatusVO read(Long statusno); //개별조회
	
	int insert(StudStatusVO studStatusVO); // 학적변동 신청 추가
	
	int update(StudStatusVO studStatusVO); // 학적변동 신청 처리
	
	int delete(StudStatusVO studStatusVO); // 학적변동 신청 취소
	
	int getStatusCnt();
	
}
