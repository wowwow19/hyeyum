package com.hyeyum.domain;

import java.util.Date;

import lombok.Data;

@Data
public abstract class PaymentVO {
	private Long amount;
	private Date payDate;
}
