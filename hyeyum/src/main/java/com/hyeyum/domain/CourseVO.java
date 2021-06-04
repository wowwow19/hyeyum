package com.hyeyum.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 
 * 강의 객체 정보
 * @author 강영훈
 * @since 2021/05/17
 */

@Data
public class CourseVO {
	private Long coursno;
	private String name;
	private Integer credit;
	private Integer maxnum;
	private Integer sugangNum;
	private Integer startTime;
	private Integer endTime;
	private Integer day;
	private Integer semester;
	private Boolean enable;
	private String regDate;
	
	private Long profno;
	private String pname;
	
	private Long deptno;
	private String dname;
	
	private String locno;
	
	private List<CourseAttachVO> attachList = new ArrayList<>();
}
