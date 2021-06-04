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
public class ProfessorCourseServiceTests {
	@Autowired
	private ProferssorCourseService service;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(service);
	}
	
	@Test
	public void testaddCourse() {
		log.info("testaddCourse....");
		CourseVO courseVO = new CourseVO();
		courseVO.setCoursno(41111L);
		courseVO.setName("java");
		courseVO.setCredit(3);
		courseVO.setEndTime(3);
		courseVO.setLocno("A101");
		courseVO.setMaxnum(30);
		courseVO.setDeptno(111L);
		courseVO.setProfno(2111103L);
		courseVO.setStartTime(1);
		courseVO.setDay(5);
		courseVO.setEnable(true);
		courseVO.setSemester(3);
		courseVO.setRegDate("210506");
		
		log.info(service.addCourse(courseVO));
		
	}
	
	@Test
	public void testGetCouInfo() {
		log.info("testGetCouInfo....");
		CourseCategory category = new CourseCategory();
		category.setProfno(2111103L);
		category.setCoursno(41111L);
		log.info(service.getCouInfo(category));
	}
	
	@Test
	public void testGetList() {
		log.info("testGetList.....");
		CourseCategory category = new CourseCategory();
		log.info(service.getList(category));
	}
	
	@Test
	public void testGetCurrentNO() {
		log.info("testGetCurrentNO.....");
		log.info(service.getCurrentNo(111L));
		
	}
	
	@Test
	public void testGetLocationList() {
		log.info("testGetLocationList.....");
		log.info(service.getLocationList(111L));
		
	}
}
