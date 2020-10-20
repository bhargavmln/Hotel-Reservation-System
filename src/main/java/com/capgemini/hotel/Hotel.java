package com.capgemini.hotel;

public class Hotel {
	private String name;
	private int priceWeekday;
	private int priceWeekend;

	public Hotel(String name, int priceWeekday, int priceWeekend) {
		this.setName(name);
		this.setPriceWeekday(priceWeekday);
		this.setPriceWeekend(priceWeekend);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriceWeekday() {
		return priceWeekday;
	}

	public void setPriceWeekday(int priceWeekday) {
		this.priceWeekday = priceWeekday;
	}

	public int getPriceWeekend() {
		return priceWeekend;
	}

	public void setPriceWeekend(int priceWeekend) {
		this.priceWeekend = priceWeekend;
	}

	@Override
	public String toString() {
		return "Hotel Name: " + name + " Weekday Price: " + priceWeekday + " WeekendPrice";
	}
}
