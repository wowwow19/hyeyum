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
public class AdminCourseServiceTests {
	
	@Autowired
	private AdminCourseService service;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(service);
	}
	
	@Test
	public void testGetCourseList(){
		log.info("testGetCourseList.....");
		CourseCategory category = new CourseCategory();
		service.getCourseList(category).forEach(log::info);
	}
	
	@Test
	public void testGetCourse() {
		log.info("testGetCourse...");
		CourseCategory category = new CourseCategory();
		category.setCoursno(21301L);
		log.info(service.getCourse(category));
	}
	
	@Test
	public void testupdateCourse(){
		log.info("testupdateCourse...");
		CourseCategory category = new CourseCategory();
		category.setCoursno(21301L);
		CourseVO courseVO = service.getCourse(category);
		courseVO.setSemester(1);
		log.info(service.updateCourse(courseVO));
	}
	
	@Test
	public void testdeleteCourse(){
		log.info("testdeleteCourse.....");
		log.info(service.deleteCourse("32305") > 0 ? "delete success" : "delete fail");
	}
	
	@Test
	public void testgetAttachList(){
		log.info("testgetAttachList.....");
		CourseCategory category = new CourseCategory();
		service.getCourseList(category).forEach(log::info);
	}
}
