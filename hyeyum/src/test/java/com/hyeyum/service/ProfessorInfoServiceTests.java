package com.hyeyum.service;

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
public class ProfessorInfoServiceTests {
	
	@Autowired
	private ProferssorInfoService infoService;
	
	@Test
	public void testGetProInfo() {
		log.info("testGetProInfo.......");
		log.info(infoService.getProInfo("2112305"));
	}
	
	@Test
	public void testUpdateProfInfo(){
		log.info("testUpdateProfInfo");
		ProfessorVO professorVO = infoService.getProInfo("2112305");
		professorVO.setTel("010-2222-2222");
		log.info(infoService.updateProfInfo(professorVO));
	}
	
	
}
