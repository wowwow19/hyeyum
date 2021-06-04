package com.hyeyum.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.SalaryVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SalaryMapperTests {
	
	@Autowired
	private SalaryMapper salaryMapper;
	
	@Test
	public void testRead(){
		log.info("test salary Info");
		log.info(salaryMapper.read("2112305",3L));
	}

	@Test
	public void testGetList(){
		log.info("test salary List");
		salaryMapper.getList(null).forEach(log::info);
	}
	
	@Test
	public void testInsert(){
		log.info("test salary insert");
		
		SalaryVO salaryVO = new SalaryVO();
		
		salaryVO.setAmount(1000000L);
		salaryVO.setProfno("2112305");
		
		log.info(salaryMapper.insert(salaryVO) > 0 ? "삽입 성공" : "삽입 실패");
	}
	
	@Test
	public void testUpdate(){
		log.info("test salary update");
		
		SalaryVO salaryVO = salaryMapper.read("", 3L);
		
		salaryVO.setAmount(2000L);
		
		log.info(salaryMapper.update(salaryVO) > 0 ? "수정 성공" : "수정 실패");
	}
	
}
