package com.hyeyum.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;


@Data
public class MemberVO {
	private String userid;
	private String userpw;
	private String name;
	private Boolean enabled;
	private Date regDate;
	
	
	private List<AuthVO> authList;
}

