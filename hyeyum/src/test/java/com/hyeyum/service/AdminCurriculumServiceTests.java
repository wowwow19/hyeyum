package com.hyeyum.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.domain.CurriculumVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})

@Log4j
@WebAppConfiguration
public class AdminCurriculumServiceTests {
	
	@Autowired
	private AdminCurriculumService service;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(service);
	}
	
	@Test
	public void testGetList(){
		log.info("testGetList.....");
		service.getList().forEach(log::info);
	} 
	
	@Test
	public void testGet() {
		log.info("testGet...");
		log.info(service.get("11106"));
	}
	
	@Test
	public void testaddCurriculum(){
		log.info("testaddCurriculum.....");
		CurriculumVO curriculumVO = new CurriculumVO();
		curriculumVO.setCoursno(32305L);
		curriculumVO.setDeptno(323L);
		curriculumVO.setCategory("일반교양");
		log.info(service.addCurriculum(curriculumVO));
	}
	
	@Test
	public void testupdateCurriculum(){
		log.info("test updateCurriculum...");
		CurriculumVO curriculumVO = service.get("32305"); 
		curriculumVO.setCategory("전공선택");
		log.info(service.updateCurriculum(curriculumVO));
	}
	
	@Test
	public void testdeleteCurriculum(){
		log.info("test deleteCurriculum.....");
		log.info(service.deleteCurriculum("11106") > 0 ? "delete success" : "delete fail");
		
	}
}
