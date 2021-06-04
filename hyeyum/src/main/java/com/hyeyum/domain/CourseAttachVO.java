package com.hyeyum.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
public class CourseAttachVO extends AttachFileDTO {
	private Long coursno;
}
