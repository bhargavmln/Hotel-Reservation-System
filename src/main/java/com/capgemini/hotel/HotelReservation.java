package com.capgemini.hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {

	static List<Hotel> hotels = new ArrayList<Hotel>();

	public static void main(String[] args) {

		System.out.println("Welcome to Hotel Reservation Program");

	}

	public static void addHotel(String hotelName, int weekEndRate, int weekDayRate) {
		Customer regularCustomer = new Customer(weekDayRate, weekEndRate);
		hotels.add(new Hotel(hotelName, regularCustomer));
	}
}
