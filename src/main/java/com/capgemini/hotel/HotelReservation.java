package com.capgemini.hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservation {
	private static Scanner sc = new Scanner(System.in);	
	private static ArrayList<Hotel> hotelList = new ArrayList<>();
	
	public ArrayList<Hotel> getHotelList() {
		return hotelList;
	}
	
	public static void addHotel(){
		System.out.println("Enter the name of hotel:");
		String name = sc.nextLine();
		System.out.println("Enter the price:");
		int price = sc.nextInt();
		Hotel temp = new Hotel(name,price);
		hotelList.add(temp);
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation");
		Hotel lakeWood=new Hotel("Lakewood",110);
		Hotel bridgeWood=new Hotel("Bridgewood",110);
		Hotel ridgeWood=new Hotel("Ridgewood",110);
		hotelList.add(lakeWood);
		hotelList.add(bridgeWood);
		hotelList.add(ridgeWood);
		System.out.println(hotelList);
	}
}