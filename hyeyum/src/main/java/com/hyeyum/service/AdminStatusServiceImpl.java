package com.hyeyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyeyum.domain.StatusCategory;
import com.hyeyum.domain.StudStatusVO;
import com.hyeyum.domain.StudentVO;
import com.hyeyum.mapper.StudStatusMapper;
import com.hyeyum.mapper.StudentMapper;
import com.hyeyum.mapper.SugangMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class AdminStatusServiceImpl implements AdminStatusService{

	@Autowired
	private StudStatusMapper studStatusMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private SugangMapper sugangMapper;

	@Override
	public List<StudStatusVO> getStatusList(StatusCategory category) {
		log.info("getStatusList.....");
		return studStatusMapper.getList(category);
	}

	@Override
	public StudStatusVO getStatus(Long statusno) {
		log.info("getStatus.....");
		return studStatusMapper.read(statusno);
	}
	
	@Override
	@Transactional
	public int updateStatus(StudStatusVO studStatusVO) {
		log.info("updateStatus.....");
		int cnt = studStatusMapper.update(studStatusVO);
		StudentVO studentVO = studentMapper.read(studStatusVO.getStudno());
		//log.info(studentVO);
		//log.info(studStatusVO.getChange());
		studentVO.setStatus(studStatusVO.getChange());
		studentMapper.updateInfo(studentVO);
		sugangMapper.deleteAll(studStatusVO.getStudno());
		return cnt;
	}

};
