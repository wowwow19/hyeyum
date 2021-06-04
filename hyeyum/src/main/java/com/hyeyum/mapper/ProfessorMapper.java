package com.hyeyum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hyeyum.domain.ProfessorVO;

/**
 * 교수(ProfessorVO) 클래스와 관련된 테이블의 데이터를 조작하는 매퍼 인터페이스
 * @author 오승현
 * @since 2021 / 05 / 17
 *
 */
public interface ProfessorMapper {
	
	public int insert(ProfessorVO professorVO);
	
	public int update(ProfessorVO professorVO);
	
	/**
	 * 초기 계정생성을 해주는 메서드
	 * @author 오승현
	 *
	 */
	int generateAccount(@Param("profno") String profno, @Param("password") String password);
	
	public List<ProfessorVO> getList();
	
	public ProfessorVO read(String profno);
	
	public int delete(Long profno);
	
	int updatePassword(@Param("userid") String userid, @Param("userpw") String userpw);
	
	int getProfCnt();
	
	int getChargeStudCnt(String profno);
	
	int getChargeCourseCnt(String profno);
	
	int getCorrCnt(String profno);
	
	
	
	
}
