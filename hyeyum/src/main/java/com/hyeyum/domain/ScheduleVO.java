package com.hyeyum.domain;

import lombok.Data;

@Data
public class ScheduleVO {
	private Long scheno;
	private String startDay;
	private String endDay;
	private String content;
	
	public String getStartDayStr() {
		return this.startDay + " 00:00:00";
	}
	
	public String getEndDayStr() {
		return this.endDay + " 23:59:59";
	}
}
