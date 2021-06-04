package com.hyeyum.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})

@Log4j
@WebAppConfiguration
public class AdminEstablishServiceTests {
	
	@Autowired
	private AdminEstablishService service;
	
	@Test
	public void testExist() {
		log.info("testExist.....");
		log.info(service);
	}
	
	@Test
	public void testGetList(){
		log.info("testGetList.....");
		CourseCategory category = new CourseCategory();
		service.getList(category).forEach(log::info);
	}
	
	@Test
	public void testGetCourse() {
		log.info("testGetCourse.....");
		CourseCategory category = new CourseCategory();
		category.setCoursno(11106L);
		log.info(service.getCourse(category));
	}
	
	@Test
	public void testapproveCourse(){
		log.info("testapproveCourse.....");
		CourseCategory category = new CourseCategory();
		category.setCoursno(32305L);
		CourseVO courseVO = service.getCourse(category);
		courseVO.setEnable(true);
		log.info(service.approveCourse(courseVO));
	}
	
}
