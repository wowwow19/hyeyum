package com.hyeyum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.hyeyum.domain.CorrectionCategory;
import com.hyeyum.domain.CorrectionVO;

/**
 * 성적이의신청내역 테이블의 데이터를 조작하는 매퍼 인터페이스
 * @author 전민우
 * @since 21/05/22
 */
public interface CorrectionMapper {
	/**
	 * 단일 이의신청 내역을 조회하는 메서드
	 * @author 전민우
	 */
	CorrectionVO get(Long corrno);
	
	/**
	 * 특정 카테고리에 해당하는 이의신청 내역의 목록을 조회하는 메서드
	 * @author 전민우
	 */
	List<CorrectionVO> getList(CorrectionCategory category);
	
	/**
	 * 이의신청내역을 추가하는 메서드
	 * @author 전민우
	 */
	int insert(CorrectionVO correctionVO);
	
	/**
	 * 이의신청내역을 수정하는 메서드
	 * @author 전민우
	 */
	int update(CorrectionVO correctionVO);
	
	/**
	 * 이의신청내역을 삭제하는 메서드
	 * @author 전민우
	 */
	@Delete("DELETE FROM TBL_CORRECTION WHERE CORRNO = #{corrno}")
	int delete(CorrectionVO correctionVO);
}
