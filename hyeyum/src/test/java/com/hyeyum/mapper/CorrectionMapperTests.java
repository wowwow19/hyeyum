package com.hyeyum.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.CorrectionCategory;
import com.hyeyum.domain.CorrectionVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CorrectionMapperTests {
	@Autowired
	private CorrectionMapper mapper;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(mapper != null ? "success" : "fail");
	}
	
	@Test
	public void testGet() {
		log.info("testGet...");
		log.info(mapper.get(2L));
	}
	
	@Test
	public void testGetList() {
		log.info("testGetList...");
		
		CorrectionCategory category = new CorrectionCategory();
//		category.setDeptno(111L);
//		category.setStatus(true);
		
		mapper.getList(category).forEach(log::info);
	}
	
	@Test
	public void testInsert() {
		log.info("testInsert...");
		
		CorrectionVO correctionVO = new CorrectionVO();
		correctionVO.setStudno(21111004L);
		correctionVO.setCoursno(31301L);
		correctionVO.setReason("성적이 부당합니다");
		
		log.info(mapper.insert(correctionVO) > 0 ? "insert success" : "insert fail");
	}
	
	@Test
	public void testUpdate() {
		log.info("testUpdate...");
		
		CorrectionVO correctionVO = mapper.get(2L);
		correctionVO.setReason("수정된 사유");
		correctionVO.setCorrStatus(1);
		
		log.info(mapper.update(correctionVO) > 0 ? "update success" : "update fail");
	}
	
	@Test
	public void testDelete() {
		log.info("testDelete...");
		
		CorrectionVO correctionVO = mapper.get(2L);
		
		log.info(mapper.delete(correctionVO) > 0 ? "delete success" : "delete fail");
	}
}
