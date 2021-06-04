package com.hyeyum.domain;

import lombok.Data;

/**
 * 학적변동내역 목록에 대한 카테고리 정보를 매핑하는 클래스
 * @author 전민우
 * @since 2021/05/17
 */
@Data
public class StatusCategory {
	Long studno;
	Boolean status;
	Boolean change;
	String year;
}
