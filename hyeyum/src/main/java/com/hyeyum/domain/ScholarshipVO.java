package com.hyeyum.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 장학금 지급 내역을 저장하는 클래스
 * @author 전민우
 * @since 2021/05/19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ScholarshipVO extends PaymentVO{
	private Long schono;
	private Integer semester;
	
	private Long studno;
	private String studname;
	
	private Long deptno;
	private String deptname;
}
