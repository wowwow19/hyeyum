package com.hyeyum.service;

import java.util.Locale.Category;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hyeyum.domain.CorrectionCategory;
import com.hyeyum.domain.CorrectionVO;
import com.hyeyum.domain.CounselVO;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.domain.StudentCategory;
import com.hyeyum.domain.StudentVO;
import com.hyeyum.domain.SugangVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})

@Log4j
@WebAppConfiguration
public class StudentManagementServiceTests {
	
	@Autowired
	private StudentManagementService managementService;
	
	@Test
	public void testGetCouInfo(){
		log.info("testGetCouInfo......");
		StudentCategory category = new StudentCategory();
		category.setProfno(2111102L);
		log.info(managementService.getCouInfo(category));
	}
	
	@Test
	public void testGetCounselList(){
		log.info("testGetCounselList......");
		StudentCategory category = new StudentCategory();
		log.info(managementService.getCounselList(21111001L));
	}
	
	
	@Test
	public void testGetWriCounsel(){
		log.info("testGetWriCounsel......");
		CounselVO counselVO = new CounselVO();
		counselVO.setContent("상담이필요함");
		counselVO.setProfno("2111102");
		counselVO.setStudno("21111001");
		log.info(managementService.getwriCounsel(counselVO));
	}
	
	@Test
	public void testInsertGrade() {
		log.info("testInsertGrade........");
		SugangVO sugangVO = new SugangVO();
		sugangVO.setStudno(21111007L);
		sugangVO.setCoursno(11106L);
		sugangVO.setStudname("김기영");
		sugangVO.setStatus(true);
		sugangVO.setResult("A");
		log.info(managementService.insertGrade(sugangVO));
	}
	
	@Test
	public void testGetCorrectionList() {
		log.info("testGetCorrectionList.......");
		CorrectionCategory category = new CorrectionCategory();
		log.info(managementService.getCorrectionList(category));
	}
	
	@Test
	public void testGetSugangList() {
		log.info("testGetSugangList........");
		CourseVO courseVO = new CourseVO();
		log.info(managementService.getSugangList(11106L));
	}
	
	@Test
	public void testGetCorrection() {
		log.info("testGetCorrection...........");
		log.info(managementService.getCorrection(67L));
	}
	
	@Test
	public void testUpdateGrade() {
		log.info("testUpdateGrade........");
		CorrectionVO correctionVO = managementService.getCorrection(67L);
		correctionVO.setCorrStatus(1);
		SugangVO sugangVO = managementService.getSugang(correctionVO.getStudno(), correctionVO.getCoursno());
		sugangVO.setResult("C");
		
		log.info(managementService.updateGrade(sugangVO, correctionVO));
	}
}
