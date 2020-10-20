package com.capgemini.hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelReservation {
	private static Scanner sc = new Scanner(System.in);
	public ArrayList<Hotel> hotelList;
	public Date checkin, checkout;

	public HotelReservation() {
		hotelList = new ArrayList<Hotel>();
	}

	public void addHotel(String name, int weekdayPrice, int weekendPrice, int rating) {
		Hotel hotel = new Hotel(name, weekdayPrice, weekendPrice, rating);
		hotelList.add(hotel);
	}

	public int calcTotal(Hotel h) {
		long difference = checkout.getTime() - checkin.getTime();
		int numDays = (int) (difference / (1000 * 60 * 60 * 24)) + 1;
		int priceWeekday = h.getPriceWeekday();
		int priceWeekend = h.getPriceWeekend();
		int numOfWorkdays = getNumOfWorkdays(checkin, checkout);
		int totalAmt = (numOfWorkdays * priceWeekday + (numDays - numOfWorkdays) * priceWeekend);
		return totalAmt;
	}

	public int getNumOfWorkdays(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int workDays = 0;
		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			// excluding start date
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date

		return workDays;
	}

	public Map<Hotel, Integer> findCheapestHotel() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		System.out.println("Check-In date(ddMMMyyyy),Check-Out date(ddMMMyyyy):");
		String temp = sc.next();
		String[] dates = temp.split(",");
		try {
			checkin = dateFormat.parse(dates[0]);
			checkout = dateFormat.parse(dates[1]);
		} catch (ParseException e) {
			System.out.println("invalid check date format");
		}
		Map<Hotel,Integer> hotelCost=new HashMap<Hotel,Integer>();
		Map<Hotel,Integer> cheapList=new HashMap<Hotel,Integer>();
		for(Hotel h:hotelList) {
			hotelCost.put(h,calcTotal(h));
		}
		int low=Collections.min(hotelCost.values());
		System.out.println("Cheapest Hotel for the given dates is");
		hotelCost.forEach((k,v)->{
			if(v==low) {
				cheapList.put(k, v);
				System.out.println(k.getName()+", Total Rates: $"+v);
			}
		});
		return cheapList;
	}
	
	public Hotel findCheapestBestRatedHotel() {
		Map<Hotel,Integer>cheapList= findCheapestHotel();
		ArrayList<Integer> ratingList=new ArrayList<Integer>();
		ArrayList<Hotel> list=new ArrayList<Hotel>();
		cheapList.forEach((k,v)->{
			ratingList.add(k.getRating());
		});
		int maxRating=Collections.max(ratingList);
		cheapList.forEach((k,v)->{
			if(k.getRating()==maxRating) {
				list.add(k);
				System.out.println("Highest Rated Cheap Hotel is: \n"+ k.getName()+", Total Rates: $"+v);
			}
		});
		return list.get(0);
	}

	public static void main(String[] args) {
	}
}