package com.hyeyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyeyum.domain.CourseAttachVO;
import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.mapper.CourseAttachMapper;
import com.hyeyum.mapper.CourseMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


/**
 * 강의 관리 서비스 구현 클래스 
 * @author 강영훈
 * @since 2021-05-20
 */

@Service
@Log4j
@AllArgsConstructor
public class AdminCourseServiceImpl implements AdminCourseService{
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private CourseAttachMapper courseAttachMapper;
	
	@Override
	@Transactional
	public List<CourseVO> getCourseList(CourseCategory category) {
		log.info("get Opened CourseList....");
		
		List<CourseVO> list = courseMapper.getList(category);
		list.forEach(vo -> vo.setAttachList(courseAttachMapper.findBy(vo.getCoursno())));
		
		return list;
	}

	@Override
	@Transactional
	public CourseVO getCourse(CourseCategory category) {
		log.info("get Open Course.....");
		
		CourseVO courseVO = courseMapper.read(category);
		courseVO.setAttachList(courseAttachMapper.findBy(category.getCoursno()));
		
		return courseVO;
	}

	@Override
	@Transactional
	public int updateCourse(CourseVO courseVO) {
		log.info("update Course....."+ courseVO);
		
		courseAttachMapper.deleteAll(courseVO.getCoursno());
		courseVO.getAttachList().forEach(vo -> {
			vo.setCoursno(courseVO.getCoursno());
			courseAttachMapper.insert(vo);
		});
		int cnt = courseMapper.update(courseVO);
		
		return cnt;
	}

	@Override
	@Transactional
	public int deleteCourse(String coursno) {
		log.info("delete Course...." + coursno);
		courseAttachMapper.deleteAll(Long.parseLong(coursno));
		return courseMapper.delete(coursno);
	}

	@Override
	public List<CourseAttachVO> getAttachList(Long coursno) {
		log.info("getAttachList...");
		return courseAttachMapper.findBy(coursno);
	}
}
