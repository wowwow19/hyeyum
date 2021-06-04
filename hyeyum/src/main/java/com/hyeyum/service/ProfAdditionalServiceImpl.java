package com.hyeyum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyeyum.domain.SalaryVO;
import com.hyeyum.mapper.SalaryMapper;
import com.hyeyum.mapper.ScholarshipMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


/**
 * ProAdditionalService를 구현한 클래스
 * @author 오승현
 * @since 21 / 05 / 21
 */

@Service
@Log4j
@AllArgsConstructor
public class ProfAdditionalServiceImpl implements ProfAdditionalService{
	
	private SalaryMapper salaryMapper;
	
	@Override
	public List<SalaryVO> getSalaryList(String profno) {
		// TODO Auto-generated method stub
		
		log.info("getSalaryList.......");
		return salaryMapper.getList(profno);
	}

	@Override
	public SalaryVO getSalary(String profno, Long salno) {
		// TODO Auto-generated method stub
		
		log.info("getSalary.........");
		return salaryMapper.read(profno, salno);
	}

}
