package com.hyeyum.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.ScheduleCategory;
import com.hyeyum.domain.ScheduleVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ScheduleMapperTests {
	@Autowired
	private ScheduleMapper mapper;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(mapper != null ? "success" : "fail");
	}
	
	@Test
	public void testRead() {
		log.info("testRead...");
		log.info(mapper.read(3L));
	}
	
	@Test
	public void testGetList() {
		log.info("testGetList...");
		
		ScheduleCategory category = new ScheduleCategory();
		category.setYear(2021);
		category.setMonth(2);
		category.setDay(5);
		
		mapper.getList(category).forEach(log::info);
	}
	
	@Test
	public void testInsert() {
		log.info("testInsert...");
		
		ScheduleVO scheduleVO = new ScheduleVO();
		scheduleVO.setStartDay("2021-01-04");
		scheduleVO.setEndDay("2021-02-26");
		scheduleVO.setContent("2021학년도 제1학기 휴복학(1차)");
		
		log.info(mapper.insert(scheduleVO) > 0 ? "success" : "fail");
	}
	
	@Test
	public void testUpdate() {
		log.info("testUpdate...");
		
		ScheduleVO scheduleVO = mapper.read(4L);
		scheduleVO.setContent("2021학년도 제1학기 휴복학신청(1차)");

		log.info(mapper.update(scheduleVO) > 0 ? "success" : "fail");
	}
	
	@Test
	public void testDelete() {
		log.info("testDelete...");
		
		log.info(mapper.delete(mapper.read(5L)) > 0 ? "success" : "fail");
	}
}
