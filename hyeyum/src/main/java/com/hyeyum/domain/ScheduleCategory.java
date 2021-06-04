package com.hyeyum.domain;

import lombok.Data;

@Data
public class ScheduleCategory {
	private Integer year;
	private Integer month;
	private Integer day;
	
	public String getMonthStr() {
		return this.year + "-" + String.format("%02d", this.month);
	}
	
	public String getDayStr() {
		return this.year + "-" + String.format("%02d", this.month) + "-" + String.format("%02d", this.day);
	}
}
