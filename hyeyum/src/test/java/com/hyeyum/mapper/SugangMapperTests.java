package com.hyeyum.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.SugangVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SugangMapperTests {
	@Autowired
	private SugangMapper mapper;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(mapper != null ? "success" : "failure");
	}
	
	@Test
	public void testRead() {
		log.info("testRead");
		log.info(mapper.read(16121011L, 21205L));
	}
	
	@Test
	public void testGetList() {
		log.info("testGetList...");
		mapper.getList(21111004L).forEach(log::info);
	}
	
	@Test
	public void testGetConfirmedList() {
		log.info("testGetConfirmedList...");
		mapper.getConfirmedList(21111004L).forEach(log::info);
	}
	
	@Test
	public void testGetListWithCurriculum() {
		log.info("testGetListWithCurriculum...");
		mapper.getListWithCurriculum(21111004L).forEach(log::info);
	}
	
	@Test
	public void testGetSugangNum() {
		log.info("testGetSugangNum...");
		log.info(mapper.getSugangNum(11101L));
	}
	
	@Test
	public void testInsert() {
		log.info("testInsert...");
		
		SugangVO sugangVO = new SugangVO();
		
		sugangVO.setStudno(21111004L);
		sugangVO.setCoursno(11101L);
		
		log.info(mapper.insert(sugangVO) > 0 ? "insert success" : "insert fail");
	}
	
	@Test
	public void testUpdate() {
		log.info("testUpdate");
		
		SugangVO sugangVO = new SugangVO();
		
		sugangVO.setStudno(21111004L);
		sugangVO.setCoursno(11101L);
		sugangVO.setResult("A-");
		
		log.info(mapper.update(sugangVO) > 0 ? "update success" : "update fail");
	}
	
	@Test
	public void testDelete() {
		log.info("testDelete...");
		log.info(mapper.delete(mapper.read(16121011L, 21205L)) > 0 ? "delete success" : "delete fail");
	}
}
