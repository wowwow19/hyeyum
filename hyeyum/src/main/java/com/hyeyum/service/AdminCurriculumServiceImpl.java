package com.hyeyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyeyum.domain.CurriculumVO;
import com.hyeyum.mapper.CurriculumMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


/**
 * 교유과정 관리 서비스 구현 클래스
 * @author 강영훈
 * @since 2021-05-20
 */
@Service
@Log4j
@AllArgsConstructor
public class AdminCurriculumServiceImpl implements AdminCurriculumService{
	
	@Autowired
	private CurriculumMapper curriculumMapper;
	
	
	@Override
	public List<CurriculumVO> getList() {
		log.info("Service get curriculum list...");
		return curriculumMapper.getList();
	}

	@Override
	public int addCurriculum(CurriculumVO curriculumVO) {
		log.info("add curriculum...." + curriculumVO);
		return curriculumMapper.insert(curriculumVO);
	}

	@Override
	public int updateCurriculum(CurriculumVO curriculumVO) {
		log.info("update curriculum...." + curriculumVO);
		return curriculumMapper.update(curriculumVO);
	}

	@Override
	public int deleteCurriculum(String coursno) {
		log.info("delete curriculum" + coursno);
		return curriculumMapper.delete(coursno);
	}

	@Override
	public CurriculumVO get(String coursno) {
		log.info("get Curriculum....");
		return curriculumMapper.read(coursno);
	}

}
