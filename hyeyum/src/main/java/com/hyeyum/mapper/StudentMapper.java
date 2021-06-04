package com.hyeyum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.hyeyum.domain.MemberVO;
import com.hyeyum.domain.StudentCategory;
import com.hyeyum.domain.StudentVO;
/**
 * 학생(StudentVO) 클래스와 관련된 테이블의 데이터를 조작하는 매퍼 인터페이스
 * @author 이찬희
 * @since 2021/05/17
 */
public interface StudentMapper {
	
	/**
	 * 카테고리별 학생 데이터의 목록을 조회하는 메서드
	 * @author 이찬희
	 */
	List<StudentVO> getList(StudentCategory studentCategory);

	/**
	 * 학번을 이용하여 단일 학생의 데이터를 조회하는 메서드
	 * @author 이찬희
	 */
	StudentVO read(Long studno);
	
	/**
	 * 학생의 인적사항을 입력하는 메서드
	 * @author 전민우
	 */
	int insert(StudentVO studentVO);
	
	/**
	 * 입력된 학생 인적사항을 바탕으로 초기 계정을 생성하는 메서드
	 * @author 전민우
	 */
	int generateAccount(@Param("studno") Long studno, @Param("password") String password);
	
	/**
	 * 단일 학생의 신상정보를 수정하는 메서드
	 * @author 전민우
	 */
	int updateInfo(StudentVO studentVO);

	/**
	 * 단일 학생의 계정 비밀번호를 수정하는 메서드
	 * @author 전민우
	 */
	int updatePassword(MemberVO memberVO);
		
	/**
	 * 단일 학생의 인적사항, 계정, 등록금 납부내역, 장학금 지급내역을 일괄적으로 삭제하는 메서드
	 * @author 전민우
	 */
	@Delete("DELETE FROM TBL_STUDENT WHERE STUDNO = #{studno}")
	int delete(Long studno);
	
	int getStudCnt();
}



