package com.hyeyum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyeyum.domain.ScholarshipVO;
import com.hyeyum.domain.TuitionVO;
import com.hyeyum.mapper.CourseMapper;
import com.hyeyum.mapper.SugangMapper;
import com.hyeyum.mapper.TuitionMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class StudentAdditionalServiceImpl implements StudentAdditionalService {
	private TuitionMapper tmapper;
	@Override
	public List<TuitionVO> getTuitionList(Long tuitno) {
		log.info("getTuitionList...");
		return null;
	}

	@Override
	public List<ScholarshipVO> getScholarshipList(Long schono) {
		log.info("getScholarshipList...");
		return null;
	}

}
