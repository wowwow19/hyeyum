package com.hyeyum.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hyeyum.domain.StatusCategory;
import com.hyeyum.domain.StudStatusVO;
import com.hyeyum.domain.StudentVO;
import com.hyeyum.mapper.StudentMapper;
import com.hyeyum.mapper.SugangMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})

@Log4j
@WebAppConfiguration
public class AdminStatusServiceTests {
	@Autowired
	private AdminStatusService statusService;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private SugangMapper sugangMapper;
	
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(statusService);
	}
	
	@Test
	public void testGetStatusList() {
		log.info("testGetStatusList...");
		statusService.getStatusList(new StatusCategory()).forEach(log::info);
	}
	
	@Test
	public void testGetStatus() {
		log.info("testGetStatus....");
		log.info(statusService.getStatus(112L));
	}
	
	@Test
	@Transactional
	public void testUpdateStatus() {
		log.info("testUpdateStatus....");
		StudStatusVO studStatusVO = statusService.getStatus(112L);
		studStatusVO.setReStatus(false);
		StudentVO studentVO = studentMapper.read(studStatusVO.getStudno());
		studentVO.setStatus(studStatusVO.getChange());
		studentMapper.updateInfo(studentVO);
		sugangMapper.deleteAll(studStatusVO.getStudno());
		log.info(statusService.updateStatus(studStatusVO));
	}
	
	
}
