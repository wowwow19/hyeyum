package com.hyeyum.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.mapper.CourseAttachMapper;
import com.hyeyum.mapper.CourseMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * ProfessorCourseService를 구현한 클래스
 * @author 오승현
 * @since 21 / 05 / 20
 */

@Service
@Log4j
@AllArgsConstructor
public class ProferssorCourseServiceImpl implements ProferssorCourseService{

	private CourseMapper courseMapper;
	private CourseAttachMapper courseAttachMapper;
	
	@Override
	@Transactional
	public CourseVO getCouInfo(CourseCategory category) {
		// TODO Auto-generated method stub
		log.info("getCourInfo.....");
		
		CourseVO courseVO = courseMapper.read(category);
		courseVO.setAttachList(courseAttachMapper.findBy(category.getCoursno()));
		
		return courseVO;
	}

	@Override
	@Transactional
	public List<CourseVO> getList(CourseCategory category) {
		// TODO Auto-generated method stub
		log.info("getProfCourseList....");
		
		List<CourseVO> list = courseMapper.getList(category);
		list.forEach(vo -> vo.setAttachList(courseAttachMapper.findBy(vo.getCoursno())));
		
		return list;
	}

	@Override
	@Transactional
	public int addCourse(CourseVO courseVO) {
		// TODO Auto-generated method stub
		log.info("addCourse.......");
		
		CourseCategory courseCategory = new CourseCategory();
		courseCategory.setCoursno(courseVO.getCoursno());
		if( courseMapper.read(courseCategory) != null)
			return 0;
		
		int cnt = courseMapper.insert(courseVO);
		courseVO.getAttachList().forEach(vo -> {
			vo.setCoursno(courseVO.getCoursno());
			courseAttachMapper.insert(vo);
		});
		
		return cnt;
	}

	@Override
	public Long getCurrentNo(Long deptno) {
		log.info("getCurrentNo...");
		return courseMapper.getCurrentNo(deptno);
	}

	@Override
	public List<String> getLocationList(Long deptno) {
		log.info("getLocationList...");
		return courseMapper.getLocationList(deptno);
	}

}
