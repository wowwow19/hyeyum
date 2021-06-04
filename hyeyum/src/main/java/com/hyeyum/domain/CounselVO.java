package com.hyeyum.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 *  상담 객체 생성
 * @author 오승현
 * @since 2021 / 05 / 19
 *
 */

@Data
public class CounselVO {
	private Long counno;
	@DateTimeFormat(pattern="yyMMdd")
	private Date coundate;
	private Date regdate;
	private String content;
	private String studno;
	private String profno;

}
