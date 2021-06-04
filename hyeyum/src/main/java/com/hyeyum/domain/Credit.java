package com.hyeyum.domain;

import lombok.Data;

/**
 * 이수구분에 따른 총 이수학점의 정보를 담는 클래스
 * @author 전민우
 * @since 2021/05/20
 */
@Data
public class Credit {
	private Long studno;
	private int contexts;
	private int electives;
	private int others;
	
	public int getTotal() {
		return this.contexts + this.electives + this.others;
	}
}
