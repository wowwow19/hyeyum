package com.hyeyum.domain;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * 
 * 교수 객체 정보 
 * @author  오승현
 * @since 2021/05/17
 *
 */
@Data
public class ProfessorVO {
	private String profno;
	private String name;
	@DateTimeFormat(pattern="yyMMdd")
	private Date birthdate;
	private String address;
	private String gender;
	private String tel;
	private String email;
	@DateTimeFormat(pattern="yyMMdd")
	private Date hiredate;
	private Long sal;
	private String position;
	private String deptno;
	
	private String dname;
	private String password;
	
}
