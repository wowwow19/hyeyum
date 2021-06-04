package com.hyeyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyeyum.mapper.CourseMapper;
import com.hyeyum.mapper.ProfessorMapper;
import com.hyeyum.mapper.StudStatusMapper;
import com.hyeyum.mapper.StudentMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class CountServiceImpl implements  CountService{
	
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ProfessorMapper profMapper;
	@Autowired
	private StudStatusMapper studStatusMapper;
	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public int getStudCnt() {
		log.info("get stud Count....");
		return studentMapper.getStudCnt();
	}

	@Override
	public int getProfCnt() {
		log.info("get prof Count....");
		return profMapper.getProfCnt();
	}

	@Override
	public int getStatusCnt() {
		log.info("get status Count....");
		return studStatusMapper.getStatusCnt();
	}

	@Override
	public int getCourseCnt() {
		log.info("get Course Count....");
		return courseMapper.getCnt();
	}

	@Override
	public int getChargeStudCnt(String profno) {
		log.info("getChargeStudCnt....");
		return profMapper.getChargeStudCnt(profno);
	}

	@Override
	public int getChargeCourseCnt(String profno) {
		log.info("getChargeCourseCnt....");
		return profMapper.getChargeCourseCnt(profno);
	}

	@Override
	public int getCorrCnt(String profno) {
		log.info("getCorrCnt....");
		return profMapper.getCorrCnt(profno);
	}

}
