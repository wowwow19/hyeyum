package com.hyeyum.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.StatusCategory;
import com.hyeyum.domain.StudStatusVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class StudentStatusServiceTests {
	@Autowired
	StudentStatusService service;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(service != null ? "success" : "failure");
	}
	
	@Test
	public void testGet() {
		log.info("testGet...");
		log.info(service.get(2L));
	}
	
	@Test
	public void testGetList() {
		log.info("testGetList...");
		
		StatusCategory category = new StatusCategory();
		category.setStudno(16203036L);
		
		service.getList(category).forEach(log::info);
	}
	
	@Test
	public void testInsert() {
		log.info("testInsert...");
		
		StudStatusVO studStatusVO = new StudStatusVO();
		
		studStatusVO.setReason("유학");
		studStatusVO.setChange(false);
		
		// 현재 상태와 다른 신청내역 -> 성공해야 함
		studStatusVO.setStudno(19111002L);
		
		// 현재 상태와 같은 신청내역 -> 실패해야 함
//		studStatusVO.setStudno(19112005L);
		
		// 이미 처리되지 않은 신청내역이 있을 때 -> 실패해야 함
		
		log.info(service.insert(studStatusVO) > 0 ? "insert success" : "insert fail");
	}
	
	@Test
	public void testDelete() {
		log.info("testDelete...");
		
		StudStatusVO studStatusVO = new StudStatusVO();
		
		// 이미 처리완료된 신청내역을 취소하려하는 경우 -> 실패해야 함
//		studStatusVO.setStatusno(2L);
		
		// 처리 중인 신청내역을 취소하려하는 경우 -> 성공해야 함
		studStatusVO.setStatusno(22L);
		
		log.info(service.delete(studStatusVO) > 0 ? "delete success" : "delete fail");
	}
}
