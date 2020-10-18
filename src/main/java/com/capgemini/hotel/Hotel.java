package com.capgemini.hotel;

public class Hotel {

	String hotelName;
	Customer regularCustomer;

	public Hotel(String hotelName, Customer regularCustomer) {
		this.hotelName = hotelName;
		this.regularCustomer = regularCustomer;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	@Override
	public String toString() {
		return "Hotel Name: " + hotelName + "\nRegular Weekday Rate: " + regularCustomer.weekDayRate+ "\nRegular Weekend Rate: " + regularCustomer.weekEndRate + "\n";
	}
}
