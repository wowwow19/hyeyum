package com.hyeyum.domain;

import lombok.Data;

/**
 * 학생 목록에 대한 카테고리 정보를 매핑하는 클래스
 * @author 전민우
 * @since 2021/05/17
 */
@Data
public class StudentCategory {
	private Integer grade;
	private String gender;
	private Boolean feature;
	private Boolean status;
	private Long deptno;
	private Long profno;
}
