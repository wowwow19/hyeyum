package com.hyeyum.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.ScholarshipVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ScholarshipMapperTests {
	@Autowired
	private ScholarshipMapper mapper;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(mapper != null ? "success" : "failure");
	}
	
	@Test
	public void testRead() {
		log.info("testRead");
		log.info(mapper.read(4L));
	}
	
	@Test
	public void testGetList() {
		log.info("testGetList...");
		
		// 파라미터가 없을 때(전체목록 조회)
		mapper.getList(null, null).forEach(log::info);
		
		// 학번 파라미터만 있을 때
//		mapper.getList(null, 18112004L).forEach(log::info);
		
		// 학과번호 파라미터만 있을 때
//		mapper.getList(111L, null).forEach(log::info);
		
		// 파라미터가 모두 존재할 때
//		mapper.getList(111L, 21111004L).forEach(log::info);
	}
	
	@Test
	public void testInsert() {
		log.info("testInsert...");
		
		ScholarshipVO scholarshipVO = new ScholarshipVO();
		
		scholarshipVO.setAmount(2800000L);
		scholarshipVO.setSemester(2);
		scholarshipVO.setStudno(19113009L);
		
		log.info(mapper.insert(scholarshipVO) > 0 ? "insert success" : "insert fail");
	}
	
	@Test
	public void testDelete() {
		log.info("testDelete...");
		log.info(mapper.delete(19113009L) > 0 ? "delete success" : "delete fail");
	}
}
