package com.hyeyum.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.StudentVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class StudentInfoServiceTests {
	@Autowired
	private StudentInfoService service;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(service != null ? "success" : "failure");
	}
	
	@Test
	public void testGet() {
		log.info("testGet...");
		log.info(service.get(21111004L));
	}
	
	@Test
	public void testUpdate() {
		log.info("testUpdate...");
		
		StudentVO studentVO = service.get(21111004L);
		String password = "jieun20011102";
		studentVO.setAddress("대전광역시 유성구");

		log.info(service.update(studentVO) > 0 ? "update success" : "update fail");
	}
}
