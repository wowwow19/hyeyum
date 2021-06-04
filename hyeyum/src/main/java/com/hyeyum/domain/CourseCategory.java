package com.hyeyum.domain;

import lombok.Data;

@Data
public class CourseCategory {
	private String year;
	private Long coursno;
	private String cname;
	private Long profno;
	private String pname;
	private Long deptno;
	private Integer semester;
	private Boolean enable;
}
