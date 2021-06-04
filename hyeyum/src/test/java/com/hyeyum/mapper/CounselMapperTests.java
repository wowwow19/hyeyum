package com.hyeyum.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.CounselVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CounselMapperTests {
	
	@Autowired
	private CounselMapper counselmapper;
	
	@Test
	public void testGetList() {
		
		counselmapper.getList(21111001L).forEach(log::info);
	}
	
	@Test
	public void testRead(){
		log.info("Counsel info test....");
		log.info(counselmapper.read(2L));
	}
	
	@Test
	public void testInsert() throws ParseException{
		log.info("Counsel insert test....");
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = format.parse("2021/05/01");
		CounselVO counselVO = new CounselVO();
		counselVO.setCounno(1L);
		counselVO.setContent("상담 내용");
		counselVO.setCoundate(date);
		counselVO.setRegdate(date);
		counselVO.setProfno("1111111");
		counselVO.setStudno("21111001");
		
		log.info(counselmapper.insert(counselVO) > 0 ? "삽입 성공" : "삽입 실패");
	
	}
	
	@Test
	public void testDelete() {
		log.info("Counsel delete test....");
		log.info(counselmapper.delete("1") > 0 ? "삭제 성공" : "삭제 실패");
		
	}

}
