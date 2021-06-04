package com.hyeyum.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.domain.CurriculumVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CurriculumMapperTests {
	@Autowired
	private CurriculumMapper curriculumMapper;
	@Autowired
	private CourseMapper courseMapper;
	
	@Test
	public void testRead(){
		log.info("test curriculum Info");
		log.info(curriculumMapper.read("11101"));
	}

	@Test
	public void testGetList(){
		log.info("test curriculum List");
		curriculumMapper.getList().forEach(log::info);
	}
	
	@Test
	public void testInsert(){
		log.info("test curriculum insert");
		CourseCategory category = new CourseCategory();
		category.setCoursno(11106L);
		CourseVO courseVO = courseMapper.read(category);
		
		CurriculumVO curriculumVO = new CurriculumVO();
		
		curriculumVO.setCoursno(courseVO.getCoursno());
		curriculumVO.setDeptno(courseVO.getDeptno());
		curriculumVO.setCategory("전공선택");
		log.info(curriculumVO);
		int result = curriculumMapper.insert(curriculumVO);
		log.info(result > 0 ? "삽입 성공" : "삽입 실패");
	}
	
	@Test
	public void testUpdate(){
		log.info("test curriculum update");
		
		CurriculumVO curriculumVO = curriculumMapper.read("11106");
		
		curriculumVO.setCategory("전공필수");
		
		log.info(curriculumMapper.update(curriculumVO) > 0 ? "수정 성공" : "수정 실패");
	}
	
	@Test
	public void testDelete(){
		log.info("test curriculum delete");
		
		log.info(curriculumMapper.delete("11106") > 0 ? "삭제 성공" : "삭제 실패");
	}
	
}
