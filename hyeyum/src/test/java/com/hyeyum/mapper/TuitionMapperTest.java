package com.hyeyum.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.SalaryVO;
import com.hyeyum.domain.TuitionVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TuitionMapperTest {
	@Autowired
	private TuitionMapper mapper;
	
	
	
	@Test
	public void testRead() {
		log.info("testRead");
		log.info(mapper.read(2L));
	}
	
	@Test
	public void testGetList() {
		log.info("testGetList...");
		mapper.getList().forEach(log :: info);
	
	}
	
	@Test
		public void testInsert() {
		log.info("testInsert...");
		
		TuitionVO tuitionVO = new TuitionVO();
		tuitionVO.setAmount(3500000L);
		tuitionVO.setSemester(2);
		tuitionVO.setStudNo(21111004L);
		log.info(mapper.insert(tuitionVO) > 0 ? "성공" : "실패");
	}
	
	@Test
	public void testDelete() {
		log.info("testDelete...");
		log.info(mapper.delete(5L) > 0 ? "성공" : "실패");
	}
	
	@Test
	public void testUpdate(){
		log.info("test salary update");
		
		TuitionVO tuitionVO = mapper.read(8L);
		
		tuitionVO.setAmount(2000000L);
		
		log.info(mapper.update(tuitionVO) > 0 ? "수정 성공" : "수정 실패");
	}
}
