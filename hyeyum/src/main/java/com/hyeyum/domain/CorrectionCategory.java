package com.hyeyum.domain;

import lombok.Data;

/**
 * 성적이의신청 목록에 대한 카테고리 정보를 매핑하는 클래스
 * @author 전민우
 * @since 2021/05/17
 */
@Data
public class CorrectionCategory {
	private Long studno;
	private Long coursno;
	private Long deptno;
	private Long profno;
	private Boolean status;
}
