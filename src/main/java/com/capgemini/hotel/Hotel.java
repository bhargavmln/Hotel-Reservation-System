package com.capgemini.hotel;

public class Hotel {

	String hotelName;
	int regularWeekdayPrice;
	int regularWeekendPrice;

	public Hotel(String hotelName, int regularWeekdayPrice, int regularWeekendPrice) {
		super();
		this.hotelName = hotelName;
		this.regularWeekdayPrice = regularWeekdayPrice;
		this.regularWeekendPrice = regularWeekendPrice;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularWeekdayPrice() {
		return regularWeekdayPrice;
	}

	public void setRegularWeekdayPrice(int regularWeekdayPrice) {
		this.regularWeekdayPrice = regularWeekdayPrice;
	}

	public int getRegularWeekendPrice() {
		return regularWeekendPrice;
	}

	public void setRegularWeekendPrice(int regularWeekendPrice) {
		this.regularWeekendPrice = regularWeekendPrice;
	}

	@Override
	public String toString() {
		return "Hotel Name: " + hotelName + "\nRegular Weekday Rate: " + regularWeekdayPrice
				+ "\nRegular Weekend Rate: " + regularWeekendPrice + "\n";
	}
}
