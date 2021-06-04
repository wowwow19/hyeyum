
package com.hyeyum.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * 학생 데이터를 담는 VO
 * @author 이찬희
 * @since 2021/05/17
 */
@Data
public class StudentVO {
	private Long studno;
	private String name;
	private String password;
	@DateTimeFormat(pattern="yyMMdd")
	private Date birthDate;
	private String address;
	private String tel;
	private Integer grade;
	private String gender;
	private String email;
	private Boolean feature;
	private Boolean status;
	
	private Long deptno;
	private String deptname;
	
	private Long profno;
	private String profname;
}
