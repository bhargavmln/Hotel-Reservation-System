package com.capgemini.hotel;

public class Customer {
	int weekDayRate;
	int weekEndRate;
	
	public Customer(int weekDayRate, int weekEndRate) {
		this.weekDayRate = weekDayRate;
		this.weekEndRate = weekEndRate;
	}

	public int getWeekDayRate() {
		return weekDayRate;
	}

	public void setWeekDayRate(int weekDayRate) {
		this.weekDayRate = weekDayRate;
	}

	public int getWeekEndRate() {
		return weekEndRate;
	}

	public void setWeekEndRate(int weekEndRate) {
		this.weekEndRate = weekEndRate;
	}
}
