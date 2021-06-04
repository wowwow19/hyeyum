package com.hyeyum.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 수강신청내역의 정보를 담는 클래스
 * @author 전민우
 * @since 21/05/20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SugangVO extends CurriculumVO{
	private Long studno;
	private String studname;
	private Boolean status;
	private String result;
}
