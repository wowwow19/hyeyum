package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.ProfessorVO;
import com.hyeyum.domain.StudentCategory;
import com.hyeyum.domain.StudentVO;

/**
 * 인적관리 서비스 인터페이스 
 * @author 박수연
 * @since 2021-05-20
 */
public interface AdminHRService { 
	
	/**
	 * 학생목록 조회하는 메서드 
	 * @author 강영훈
	 */
	List<StudentVO> getStudentList(StudentCategory studentCategory);
	
	/**
	 * 학생 인적관리 등록하는 메서드 
	 * @author 강영훈
	 */
	StudentVO getStudent(Long studno);
	
	/**
	 * 학생 인적관리 수정하는 메서드 
	 * @author 강영훈
	 */
	int updateStudent(StudentVO studentVO);
	
	/**
	 * 교수목록 조회하는 메서드 
	 * @author 박수연
	 */
	List<ProfessorVO> getProfessorList();
	
	/**
	 * 교수 인적관리 등록하는 메서드 
	 * @author 박수연
	 */
	ProfessorVO getProfessor(String profno);
	
	/**
	 * 교수 인적관리 수정하는 메서드 
	 * @author 박수연
	 */
	int updateProfessor(ProfessorVO professorVO);
	
	/**
	 * 학생 계정 부여하는 메서드 
	 * @author 박수연
	 */
	int addStudent(StudentVO studentVO);
	
	/**
	 * 교수 계정 부여하는 메서드 
	 * @author 박수연
	 */
	int addProfessor(ProfessorVO professorVO);
	
	/**
	 * 학생 계정 삭제하는 메서드 
	 * @author 박수연
	 */
	int deleteStudent(Long studno);
	
	/**
	 * 교수 계정 삭제하는 메서드 
	 * @author 박수연
	 */
	int deleteProfessor(Long profno);

}
