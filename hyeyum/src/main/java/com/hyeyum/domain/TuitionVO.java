package com.hyeyum.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 등록금 납부내역을 저장하는 클래스
 * @author 이찬희
 * @since 2021/05/19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TuitionVO extends PaymentVO{
	private Long tuitno;
	private Integer semester;
	
	private Long studNo;
	private String studName;
	
	private Long deptNo;
	private String deptName;
}
