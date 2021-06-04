package com.hyeyum.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hyeyum.domain.ProfessorVO;
import com.hyeyum.domain.StudentCategory;
import com.hyeyum.domain.StudentVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})

@Log4j
@WebAppConfiguration
public class AdminHRServiceTests {
	
	@Autowired
	private AdminHRService hrService;

	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(hrService);
	}
	
	@Test
	public void testGetStudentList() {
		log.info("testGetStudentList....");
		hrService.getStudentList(new StudentCategory()).forEach(log::info);
	}
	
	@Test
	public void testGetStudent() {
		log.info("testGetStudent....");
		log.info(hrService.getStudent(21112001L));
	}
	
	@Test
	public void testAddStudent() throws ParseException {
		log.info("testAddStudent....");
		StudentVO studentVO = new StudentVO();
		// NOT NULL 컬럼
		studentVO.setStudno(21111009L);
		studentVO.setName("테스형");
		String birthDate = "20001111";
		studentVO.setBirthDate(new SimpleDateFormat("yyyyMMdd").parse(birthDate));
		studentVO.setGender("M");
		studentVO.setDeptno(111L);
		
		// NULL 허용 컬럼
		studentVO.setAddress("충청남도 천안시 성정동");
		studentVO.setFeature(false);
		log.info(hrService.addStudent(studentVO));
	}
	
	@Test
	public void testUpdateStudent() {
		log.info("testUpdateStudent....");
		StudentVO studentVO = hrService.getStudent(21111009L);
		studentVO.setName("태진아");
		log.info(hrService.updateStudent(studentVO) > 0 ? "success" : "fail");
	}
	
	@Test
	public void testDeleteStudent() {
		log.info("testDeleteStudent....");
		log.info(hrService.deleteStudent(21111009L));
	}
	
	@Test
	public void testGetProfessorList() {
		log.info("testGetProfessorList....");
		hrService.getProfessorList().forEach(log::info);
	}
	
	@Test
	public void testGetProfessor() {
		log.info("testGetProfessor....");
		log.info(hrService.getProfessor("2111101"));
	}
	
	@Test
	public void testAddProfessor() throws ParseException {
		log.info("testAddProfessor...");
		ProfessorVO professorVO = new ProfessorVO();
		professorVO.setProfno("2111108");
		professorVO.setName("유재석");
		String birthDate = "20001111";
		professorVO.setBirthdate(new SimpleDateFormat("yyyyMMdd").parse(birthDate));
		professorVO.setAddress("충남 천안시");
		professorVO.setGender("M");
		professorVO.setTel("010-1112-1111");
		professorVO.setSal(5000000L);
		professorVO.setPosition("정교수");
		professorVO.setDeptno("111");
		log.info(hrService.addProfessor(professorVO) > 0 ? "success" : "fail");
	}
	
	@Test
	public void testUpdateProfessor() {
		log.info("testUpdateProfessor...");
		ProfessorVO professorVO = hrService.getProfessor("2111108");
		professorVO.setPosition("부교수");
		log.info(hrService.updateProfessor(professorVO) > 0 ? "success" : "fail");
	}
	
	@Test
	public void testDeleteProfessor() {
		log.info("testDeleteProfessor....");
		log.info(hrService.deleteProfessor(2111108L) > 0 ? "success" : "fail");
	}
}
