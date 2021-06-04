package com.hyeyum.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.domain.SugangVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
@WebAppConfiguration
public class StudentCourseServiceTests {
	@Autowired
	private StudentCourseService service;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(service);
	}
	
	@Test
	public void testGet() {
		log.info("testGet...");
		
		CourseCategory category = new CourseCategory();
		category.setCoursno(11101L);
		
		log.info(service.get(category));
	}
	
	@Test
	public void testCourseList() {
		log.info("testGetCourseList...");
		
		CourseCategory category = new CourseCategory();
		category.setDeptno(111L);
		
		service.getCourseList(category).forEach(log::info);
	}
	
	@Test
	public void testGetTimeTable() {
		log.info("testGetTimeTable");
		String[] day = {"월", "화", "수", "목", "금"};
		
		CourseVO[][] timeTable = service.getTimeTable(21111004L, true);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 8; j++) {
				log.info(day[i] + "요일 " + (j+1) + "교시 : " + timeTable[i][j]);
			}
		}
	}

	@Test
	public void testGetSugang() {
		log.info("testGetSugang...");
		log.info(service.getSugang(21111007L, 11106L));
	}
	
	@Test
	public void testGetSugangList() {
		log.info("testGetSugangList...");
		service.getSugangList(21111004L).forEach(log::info);
	}

	@Test
	public void testGetConfirmedSugangList() {
		log.info("testGetConfirmedSugangList...");
		service.getConfirmedSugangList(21111004L).forEach(log::info);
	}
	
	@Test
	public void testAddSugang() {
		log.info("testAddSugang...");
		
		SugangVO sugangVO = new SugangVO();
		
		sugangVO.setStudno(21111004L);
		
		// 시간이 중복되지 않는 강의를 넣었을 때
		sugangVO.setCoursno(31301L);
		
		// 시간이 중복되는 강의를 넣었을 때 
//		sugangVO.setCoursno(32102L);
		
		log.info(service.addSugang(sugangVO) > 0 ? "add success" : "add fail");
	}
	
	@Test
	public void testDeleteSugang() {
		log.info("testDeleteSugang");
		
		SugangVO sugangVO = service.getSugang(21111004L, 12201L);
		
		log.info(service.deleteSugang(sugangVO) > 0 ? "delete success" : "delete fail");
	}
	
	@Test
	public void testCompleteSugang() {
		log.info("testCompleteSugang...");
		log.info("complete " + service.completeSugang(21111004L) + " courses");
	}
}
