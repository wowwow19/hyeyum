package com.hyeyum.domain;

import java.util.Date;

import lombok.Data;

/**
 * 성적 이의신청에 대한 데이터를 담는 VO
 * @author 전민우
 * @since 2021/05/17
 */
@Data
public class CorrectionVO {
	private Long corrno;
	private String reason;
	private Long studno;
	private String studname;
	private Long coursno;
	private String coursname;
	private Long profno;
	private Integer corrStatus; // 0 처리중 1 승인됨 2 승인거부 
	private Date regDate;
}
