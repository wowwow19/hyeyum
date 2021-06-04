package com.hyeyum.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyeyum.domain.AuthVO;
import com.hyeyum.domain.MemberVO;
import com.hyeyum.domain.ProfessorVO;
import com.hyeyum.domain.StudentCategory;
import com.hyeyum.domain.StudentVO;
import com.hyeyum.mapper.MemberMapper;
import com.hyeyum.mapper.ProfessorMapper;
import com.hyeyum.mapper.StudentMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class AdminHRServiceImpl implements AdminHRService{
	
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ProfessorMapper professorMapper;
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired @Qualifier("BCryptPasswordEncoder")
	private PasswordEncoder encoder;
	
	@Override
	@Transactional
	public int addStudent(StudentVO studentVO) {
		log.info("addStudent.....");
		int studCnt = studentMapper.insert(studentVO);
//		SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
//		Date date = studentVO.getBirthDate();
//		String tempPassword = format.format(date);
		studentMapper.generateAccount(studentVO.getStudno(),new SimpleDateFormat("yyMMdd").format(studentVO.getBirthDate()));
		MemberVO memberVo = new MemberVO();
		memberVo.setUserid(Long.toString(studentVO.getStudno()));
		memberVo.setUserpw(encoder.encode(new SimpleDateFormat("yyMMdd").format(studentVO.getBirthDate())));
		memberMapper.insert(memberVo.getUserid(), memberVo.getUserpw(), studentVO.getName());
		AuthVO authVO = new AuthVO();
		authVO.setUserid(memberVo.getUserid());
		memberMapper.insertStudAuth(authVO);
		return studCnt;
	}
	
	@Override
	@Transactional
	public int addProfessor(ProfessorVO professorVO) {
		log.info("addProferssor.....");
		int profCnt = professorMapper.insert(professorVO);
		professorMapper.generateAccount(professorVO.getProfno(), new SimpleDateFormat("yyMMdd").format(professorVO.getBirthdate()));
		MemberVO memberVo = new MemberVO();
		memberVo.setUserid(professorVO.getProfno());
		memberVo.setUserpw(encoder.encode(new SimpleDateFormat("yyMMdd").format(professorVO.getBirthdate())));
		memberMapper.insert(memberVo.getUserid(), memberVo.getUserpw(), professorVO.getName());
		AuthVO authVO = new AuthVO();
		authVO.setUserid(memberVo.getUserid());
		memberMapper.insertProfAuth(authVO);
		return profCnt;
	}
	
	@Override
	@Transactional
	public int deleteStudent(Long studno) {
		log.info("deleteStudent.....");
		int studCnt = studentMapper.delete(studno);
		memberMapper.delete(Long.toString(studno));
		return studCnt;
	}
	@Override
	@Transactional
	public int deleteProfessor(Long profno) {
		log.info("deleteProferssor.....");
		int profCnt = professorMapper.delete(profno);
		memberMapper.delete(Long.toString(profno));
		return profCnt;
	}

	@Override
	public List<StudentVO> getStudentList(StudentCategory studentCategory) {
		log.info("Get StudentList....");
		return studentMapper.getList(studentCategory);
	}

	@Override
	public StudentVO getStudent(Long studno) {
		log.info("Get Student....");
		return studentMapper.read(studno);
	}

	@Override
	public List<ProfessorVO> getProfessorList() {
		log.info("getProfessorList....");
		return professorMapper.getList();
	}

	@Override
	public ProfessorVO getProfessor(String profno) {
		log.info("getProfessor....");
		return professorMapper.read(profno);
	}

	@Override
	public int updateStudent(StudentVO studentVO) {
		log.info("updateStudent....");
		return studentMapper.updateInfo(studentVO);
	}

	@Override
	public int updateProfessor(ProfessorVO professorVO) {
		log.info("updateProfessor....");
		return professorMapper.update(professorVO);
	}

}
