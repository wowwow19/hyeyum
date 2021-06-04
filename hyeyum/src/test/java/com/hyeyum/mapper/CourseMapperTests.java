package com.hyeyum.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CourseMapperTests {
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(courseMapper);
	}
	
	@Test
	public void testGetList() {
		CourseCategory category = new CourseCategory();
		category.setEnable(false);
		courseMapper.getList(category).forEach(log::info);
	}
	
	@Test
	public void testRead(){
		CourseCategory category = new CourseCategory();
		category.setEnable(false);
		log.info("Course info test....");
		log.info(courseMapper.read(category));
	}
	
	@Test
	public void testInsert(){
		log.info("Course insert test....");
		
		CourseVO courseVO = new CourseVO();
		
		courseVO.setCoursno(11106L);
		courseVO.setName("선형대수학");
		courseVO.setCredit(3);
		courseVO.setDay(1);
		courseVO.setStartTime(2);
		courseVO.setEndTime(4);
		courseVO.setLocno("A105");
		courseVO.setMaxnum(70);
		courseVO.setSemester(3);
		courseVO.setDeptno(111L);
		courseVO.setProfno(2111103L);
		
		log.info(courseMapper.insert(courseVO) > 0 ? "삽입 성공" : "삽입 실패");
	
	}
	
	@Test
	public void testUpdate() {
		log.info("Course update test....");
		CourseCategory category = new CourseCategory();
		category.setCoursno(11106L);
		CourseVO courseVO = courseMapper.read(category);
		courseVO.setCredit(2);
		courseVO.setDay(2);
		courseVO.setStartTime(2);
		courseVO.setEndTime(3);
		courseVO.setLocno("A102");
		courseVO.setMaxnum(60);
		courseVO.setSemester(4);
		log.info(courseMapper.update(courseVO) > 0 ? "수정 성공" : "수정 실패");
	}
	
	@Test
	public void testDelete() {
		log.info("Course delete test....");
		log.info(courseMapper.delete("11106") > 0 ? "삭제 성공" : "삭제 실패");
		
	}
	
	
}
