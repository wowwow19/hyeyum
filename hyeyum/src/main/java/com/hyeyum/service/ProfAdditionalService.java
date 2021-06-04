package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.SalaryVO;

/**
 * 교수 급여관리와 관련된 서비스의 기능을 정의하는 인터페이스
 * @author 오승현
 * @since 2021/05/21
 *
 */

public interface ProfAdditionalService {

	List<SalaryVO> getSalaryList(String profno);
	
	SalaryVO getSalary(String profno, Long salno);
	
	
}
