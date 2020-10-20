package com.capgemini.hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HotelReservation {
	private static Scanner sc = new Scanner(System.in);	
	public ArrayList<Hotel> hotelList;
	public Date checkin,checkout;
	
	public HotelReservation() {
		hotelList = new ArrayList<Hotel>();
	}
	
	public void addHotel(String name, int weekdayPrice, int weekendPrice){
		Hotel hotel = new Hotel(name,weekdayPrice,weekendPrice);
		hotelList.add(hotel);
	}
	
	public String findCheapestHotel() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		System.out.println("Check-In date(ddMMMyyyy),Check-Out date(ddMMMyyyy):");
		String temp = sc.next();
		String[] dates=temp.split(",");
		try {
			checkin = dateFormat.parse(dates[0]);
			checkout = dateFormat.parse(dates[1]);
		} 
		catch (ParseException e) {
			System.out.println("invalid checkin date");
		}
		long difference = checkout.getTime() - checkin.getTime();
	    int numDays = (int) (difference / (1000*60*60*24))+1;
		Hotel cheapestHotel=hotelList.get(0);
		for(Hotel h:hotelList) {
			if(h.getPriceWeekday()<cheapestHotel.getPriceWeekday()) {
				cheapestHotel=h;
			}
		}
		int price=cheapestHotel.getPriceWeekday();
		String hotelName=cheapestHotel.getName();
		int totalAmt= (int)numDays*price;
		System.out.println("Cheapest Hotel for the given dates is \n"+hotelName+", Total Rates: $"+totalAmt);
		return hotelName;
	}
	
	public static void main(String[] args) {
	}
}