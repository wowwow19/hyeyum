package com.hyeyum.mapper;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hyeyum.domain.ProfessorVO;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})

@Log4j
@WebAppConfiguration
public class ProfessorMapperTests {
	@Autowired
	private ProfessorMapper professormapper;
	
	@Test
	public void testExist() {
		log.info(professormapper);
	}
	
	@Test
	public void testInsert() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = format.parse("2021/05/01");
		ProfessorVO professorVO = new ProfessorVO();
		professorVO.setProfno("1111111");
		professorVO.setName("이승현");
		professorVO.setBirthdate(date);
		professorVO.setAddress("충남 천안시");
		professorVO.setGender("M");
		professorVO.setTel("010-1112-1111");
		professorVO.setSal(5000000L);
		professorVO.setPosition("학과장");
		professorVO.setDeptno("123");
		
		professormapper.insert(professorVO);
		log.info(professorVO);
	}
	@Test
	public void testUpdate() {
		ProfessorVO professorVO = new ProfessorVO();
		professorVO.setProfno("1111111");
		professorVO.setAddress("충남 아산시");
		professorVO.setTel("010-1113-1111");
		professorVO.setSal(5100000L);
		professorVO.setPosition("정교수");
		
		professormapper.update(professorVO);
		log.info(professorVO);
	}
	
	@Test
	public void testRead(){
		log.info("Professor test.......");
		log.info(professormapper.read("2111102"));
	}
	@Test
	public void testGetList() {
		log.info("Professor test.......");
		professormapper.getList().forEach(log :: info);
	}
	
	@Test
	public void testDelete() {
		log.info("Professor test........");
		log.info(professormapper.delete(1111111L));
	}
	

}
