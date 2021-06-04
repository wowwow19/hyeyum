package com.hyeyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.mapper.CourseMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 강의 개설 신청관리 서비스 구현 클래스 
 * @author 강영훈
 * @since 2021-05-20
 */
@Service
@Log4j
@AllArgsConstructor
public class AdminEstablishServiceImpl implements AdminEstablishService{
	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public List<CourseVO> getList(CourseCategory category) {
		log.info("getCourseList....");
		
		return courseMapper.getList(category);
	}

	@Override
	public CourseVO getCourse(CourseCategory category) {
		log.info("get Course...." + category);
			
		return courseMapper.read(category);
	}

	@Override
	public int approveCourse(CourseVO courseVO) {
		log.info("approveCourse...." + courseVO);
		
		return courseMapper.enable(courseVO);
	}

//	@Override
//	public int deleteCourse(String coursno) {
//		log.info("deleteCourse...." + coursno);
//		return courseMapper.delete(coursno);
//	}

	
	
}
