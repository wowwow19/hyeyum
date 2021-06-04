package com.hyeyum.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.StudentCategory;
import com.hyeyum.domain.StudentVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class StudentMapperTests {
	@Autowired
	private StudentMapper mapper;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(mapper);
	}
	
	@Test
	public void testRead(){
		log.info("testRead...");
		log.info(mapper.read(21111004L));
	}
	
	@Test
	public void testGetList() {
		log.info("testGetList...");
		
		StudentCategory category = new StudentCategory();
		category.setProfno(2111102L);
		
		mapper.getList(category).forEach(log::info);
	}
	
	@Test
	public void testUpdateInfo(){
		log.info("testUpdateInfo...");
		
		StudentVO vo = mapper.read(21111001L);
		log.info(vo);
		
		vo.setAddress("충청남도 천안시 서북구 성정공원5로 35");
		log.info(mapper.updateInfo(vo) > 0 ? "success" : "failure");
	}
	
	@Test
	public void testUpdatePassword(){
		log.info("testUpdatePassword...");
//		log.info(mapper.updatePassword(21111001L, "jian010824") > 0 ? "success" : "failure");
	}
	
	@Test
	public void testInsert() throws ParseException {
		log.info("testInsert...");
		
		StudentVO studentVO = new StudentVO();
		// NOT NULL 컬럼
		studentVO.setStudno(21111004L);
		studentVO.setName("이지은");
		String birthDate = "20011102";
		studentVO.setBirthDate(new SimpleDateFormat("yyyyMMdd").parse(birthDate));
		studentVO.setGender("F");
		studentVO.setDeptno(111L);
		
		// NULL 허용 컬럼
		studentVO.setAddress("충청남도 천안시 성정동");
		studentVO.setFeature(false);
				
		log.info(mapper.insert(studentVO) > 0 ? "insert success" : "insert fail");
		log.info(mapper.generateAccount(studentVO.getStudno(), birthDate) > 0 ? "generate success" : "generate fail");
	}
	
	@Test
	public void testDelete() {
		log.info("testDelete...");
		log.info(mapper.delete(21111004L) > 0 ? "delete success" : "delete fail");
	}
}
