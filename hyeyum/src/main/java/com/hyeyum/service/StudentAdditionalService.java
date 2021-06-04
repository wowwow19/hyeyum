package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.ScholarshipVO;
import com.hyeyum.domain.TuitionVO;

public interface StudentAdditionalService {
	
	List<TuitionVO> getTuitionList(Long tuitno);
	
	List<ScholarshipVO> getScholarshipList(Long schono);
}
