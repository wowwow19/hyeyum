package com.hyeyum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hyeyum.domain.SalaryVO;

public interface SalaryMapper {

	List<SalaryVO> getList(@Param("profno") String profno);
	
	SalaryVO read(@Param("profno") String profno, @Param("salno")Long salno);
	
	int insert(SalaryVO salaryVO);
	
	int update(SalaryVO salaryVO);
	
}
