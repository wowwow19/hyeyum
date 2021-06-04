package com.hyeyum.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SalaryVO extends PaymentVO{
	private Long salno;
	private String profno;
	
	private String profName;

}
