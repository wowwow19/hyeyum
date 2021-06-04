package com.hyeyum.domain;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 학적변동 객체 정보
 * @author 강영훈
 * @since 2021/05/19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StudStatusVO  extends StudentVO{
	private Long statusno; 
	private String reason; // 신청사유
	private Boolean change; //변동사항
	private Boolean reStatus; //신청사항 처리여부
	private Date regDate;
}
