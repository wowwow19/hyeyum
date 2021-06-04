package com.hyeyum.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 
 * 교육과정 객체 정보
 * @author 박수연
 * @since 2021/05/17
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class CurriculumVO  extends CourseVO{
	private String category;
}
