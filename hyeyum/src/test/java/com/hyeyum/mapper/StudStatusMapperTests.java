package com.hyeyum.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.CourseVO;
import com.hyeyum.domain.StatusCategory;
import com.hyeyum.domain.StudStatusVO;
import com.hyeyum.domain.StudentVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class StudStatusMapperTests {
	
	@Autowired
	private  StudStatusMapper studStatusMapper;
	
	@Autowired
	private  StudentMapper studentMapper ;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(studStatusMapper);
	}
	
	@Test
	public void testGetList() {
		StatusCategory category = new StatusCategory();
//		category.setStudno(16203036L);
		
		studStatusMapper.getList(category).forEach(log::info);
	}
	
	@Test
	public void testRead(){
		log.info("studStatus info test....");
		log.info(studStatusMapper.read(3L));
	}
	
	@Test
	public void testInsert(){
		log.info("studStatus insert test....");
		StudStatusVO studStatusVO = new StudStatusVO();
		StudentVO studentVO = studentMapper.read(15113007L);
		
		studStatusVO.setReason("군 입영");
		studStatusVO.setChange(false);
		studStatusVO.setStudno(studentVO.getStudno());
		
		log.info(studStatusMapper.insert(studStatusVO) > 0 ? "삽입 성공" : "삽입 실패");
	
	}
	
	@Test
	public void testUpdate() {
		log.info("studStatus update test....");
		StudStatusVO studStatusVO = studStatusMapper.read(3L);
		
		studStatusVO.setReStatus(true);
	
		log.info(studStatusMapper.update(studStatusVO) > 0 ? "수정 성공" : "수정 실패");
	}
	
	@Test
	public void testDelete() {
		log.info("testDelete...");
		StudStatusVO studStatusVO = studStatusMapper.read(3L);
		
		log.info(studStatusMapper.delete(studStatusVO) > 0 ? "delete success" : "delete fail");
	}
	
}
