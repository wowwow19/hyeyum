package com.hyeyum.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hyeyum.domain.MemberVO;
import com.hyeyum.domain.ScheduleCategory;
import com.hyeyum.domain.ScheduleVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
@WebAppConfiguration
public class CommonServiceTests {
	@Autowired
	private CommonService service;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(service != null ? "success" : "fail");
	}
	
	@Test
	public void testGetSchedule() {
		log.info("testGetSchedule...");
		log.info(service.getSchedule(1L));
	}
	
	@Test
	public void testGetScheduleList() {
		log.info("testGetScheduleList...");
		
		ScheduleCategory category = new ScheduleCategory();
		category.setYear(2021);
		
		service.getScheduleList(category).forEach(log::info);
	}
	
	@Test
	public void testInsertSchedule() {
		log.info("testInsertSchedule...");
		
		ScheduleVO scheduleVO = new ScheduleVO();
		scheduleVO.setStartDay("2021-05-01");
		scheduleVO.setEndDay("2021-05-01");
		scheduleVO.setContent("근로자의 날2");
		
		log.info(service.insertSchedule(scheduleVO) > 0 ? "success" : "fail");
	}
	
	@Test
	public void testUpdateSchedule() {
		log.info("testUpdateSchedule...");
		
		ScheduleVO scheduleVO = new ScheduleVO();
		scheduleVO.setScheno(96L);
		scheduleVO.setStartDay("2021-05-01");
		scheduleVO.setEndDay("2021-05-01");
		scheduleVO.setContent("근로자의 날3");
		
		log.info(service.updateSchedule(scheduleVO) > 0 ? "success" : "fail");
	}
	
	@Test
	public void testDeleteSchedule() {
		log.info("testDeleteSchedule...");
		
		ScheduleVO scheduleVO = new ScheduleVO();
		scheduleVO.setScheno(96L);
		
		log.info(service.deleteSchedule(scheduleVO) > 0 ? "success" : "fail");
	}
	
	@Test
	public void testUpdateAccount() {
		log.info("testUpdateAccount...");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setUserid("21111004");
		memberVO.setUserpw("1234");

		log.info(service.updateAccount(memberVO) > 0 ? "success" : "fail");
	}
 }
