package com.capgemini.hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HotelReservation {
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Hotel> hotelList = new ArrayList<>();
	private static Date checkin, checkout;

	public ArrayList<Hotel> getHotelList() {
		return hotelList;
	}

	public static void addHotel() {
		System.out.println("Enter the name of hotel:");
		String name = sc.nextLine();
		System.out.println("Enter the price:");
		int price = sc.nextInt();
		Hotel temp = new Hotel(name, price);
		hotelList.add(temp);
	}

	public static String findCheapestHotel() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		System.out.println("\nEnter the chekin and check out date is the following format (ddMMMyyyy),(ddMMMyyyy):\n");
		String temp = sc.next();
		String[] dates = temp.split(",");
		try {
			checkin = dateFormat.parse(dates[0]);
			checkout = dateFormat.parse(dates[1]);
		} catch (ParseException e) {
			System.out.println("invalid checkin date");
		}
		long difference = checkout.getTime() - checkin.getTime();
		int numDays = (int) (difference / (1000 * 60 * 60 * 24)) + 1;
		Hotel cheapestHotel = hotelList.get(0);
		for (Hotel h : hotelList) {
			if (h.getPrice() < cheapestHotel.getPrice()) {
				cheapestHotel = h;
			}
		}
		int price = cheapestHotel.getPrice();
		String hotelName = cheapestHotel.getName();
		int totalAmt = (int) numDays * price;
		System.out.println("\nCheapest Hotel for the given dates is " + hotelName + "\nTotal Rates: $" + totalAmt);
		return hotelName;
	}

	public static void main(String[] args) {
	}
}