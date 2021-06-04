package com.hyeyum.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.CorrectionCategory;
import com.hyeyum.domain.CorrectionVO;
import com.hyeyum.domain.Credit;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class StudentGradeServiceTests {
	@Autowired
	private StudentGradeService service;
	
	@Test
	public void testExist() {
		log.info("testExist...");
		log.info(service != null ? "success" : "failure");
	}
	
	@Test
	public void testGetCredit() {
		log.info("testGetCredit...");
		
		Credit credit = service.getCredit(21111004L);
		
		log.info("전공필수 : " + credit.getContexts());
		log.info("전공선택 : " + credit.getElectives());
		log.info("일반 : " + credit.getOthers());
	}
	
	@Test
	public void testGetCorrection() {
		log.info("testGetCorrection...");
		log.info(service.getCorrection(2L));
	}
	
	@Test
	public void testGetCorrectionList() {
		log.info("testGetCorrectionList...");
		
		CorrectionCategory category = new CorrectionCategory();
		
		service.getCorrectionList(category).forEach(log::info);
	}
	
	@Test
	public void testRequestCorrection() {
		log.info("testRequestCorrection...");
		
		CorrectionVO correctionVO = new CorrectionVO();
		correctionVO.setStudno(21111004L);
//		correctionVO.setCoursno(11101L);
		correctionVO.setReason("부당한 성적");
		// 수강하지 않은 과목에 대해 이의신청
//		correctionVO.setCoursno(11102L);
		// 성적이 입력되지 않은 과목에 대한 이의신청
		correctionVO.setCoursno(31301L);
		
		log.info(service.requestCorrection(correctionVO) > 0 ? "insert success" : "insert fail");
	}
	
	@Test
	public void testCancleCorrection() {
		log.info("testCancleCorrection...");
		
		CorrectionVO correctionVO = new CorrectionVO();
		correctionVO.setCorrno(3L);
		
		log.info(service.cancleCorrection(correctionVO) > 0 ? "delete success" : "delete fail");
	}
	@Test
	public void testGetList(){
		log.info("testGetList...");
		service.getList(21111007L);
	}
}
