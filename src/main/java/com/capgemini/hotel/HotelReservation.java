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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HotelReservation {
	private static Scanner sc = new Scanner(System.in);
	public ArrayList<Hotel> hotelList;
	public Date checkin, checkout;

	public HotelReservation() {
		hotelList = new ArrayList<Hotel>();
	}

	// To add hotel
	public void addHotel(String name, int weekdayPrice, int weekendPrice, int rating) {
		Hotel hotel = new Hotel(name, weekdayPrice, weekendPrice, rating);
		hotelList.add(hotel);
	}

	// To set prices for reward and regular customers
	public void setPrices() {
		System.out.println("Enter 1 for regular Customer \nEnter 2 for Reward Customer\n");
		int choice = Integer.parseInt(sc.next());
		if (choice == 1) {
			addHotel("Lakewood", 110, 90, 3);
			addHotel("Bridgewood", 150, 50, 4);
			addHotel("Ridgewood", 220, 150, 5);
		}
		if (choice == 2) {
			addHotel("Lakewood", 80, 80, 3);
			addHotel("Bridgewood", 110, 50, 4);
			addHotel("Ridgewood", 100, 40, 5);
		}
	}

	// To calculate total cost for given dates
	public int calcTotal(Hotel h) {
		long difference = checkout.getTime() - checkin.getTime();
		int numDays = (int) (difference / (1000 * 60 * 60 * 24)) + 1;
		int priceWeekday = h.getPriceWeekday();
		int priceWeekend = h.getPriceWeekend();
		int numOfWeekends = getNumOfWeekends(checkin, checkout);
		int totalAmt = (numOfWeekends * priceWeekend + (numDays - numOfWeekends) * priceWeekday);
		return totalAmt;
	}

	// To get the no of week days in the given days

	public int getNumOfWeekends(Date start, Date end) {
		Calendar calStart = Calendar.getInstance();
		calStart.setTime(start);
		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(end);
		int numOfWeekend = 0;
		String day = "";
		String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday" };
		while (calStart.before(calEnd) || calStart.equals(calEnd)) {
			day = strDays[calStart.get(Calendar.DAY_OF_WEEK) - 1];
			if (day.equals("Sunday") || day.equals("Saturday")) {
				numOfWeekend++;
			}
			calStart.add(Calendar.DAY_OF_MONTH, 1);
		}
		return numOfWeekend;
	}

	public void setDates() throws InvalidInputException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyy");
		System.out.println("Check-In date(ddMMMyy),Check-Out date(ddMMMyy):");
		String temp = sc.next();
		String[] dates = temp.split(",");
		Pattern pattern = Pattern.compile("[0-9]{2}[A-Z][a-z]{2}[0-9]{2}");
		Matcher matcher1 = pattern.matcher(dates[0]);
		Matcher matcher2 = pattern.matcher(dates[1]);
		if (matcher1.matches()) {
			try {
				checkin = dateFormat.parse(dates[0]);
			} catch (ParseException e) {
				System.out.println("Cannot Parse Checkin Date");
			}
		} else {
			throw new InvalidInputException("Invalid Checkin Date");
		}
		if (matcher2.matches()) {
			try {
				checkout = dateFormat.parse(dates[1]);
			} catch (ParseException e) {
				System.out.println("Cannot Parse Checkout Date");
			}
		} else {
			throw new InvalidInputException("Invalid Checkout Date");
		}
	}

	public Map<Hotel, Integer> findCheapestHotel() throws InvalidInputException {
		setPrices();
		setDates();
		Map<Hotel, Integer> hotelCost = new HashMap<Hotel, Integer>();
		Map<Hotel, Integer> cheapList = new HashMap<Hotel, Integer>();
		hotelCost = hotelList.stream().collect(Collectors.toMap(h -> h, h -> calcTotal(h)));
		int low = Collections.min(hotelCost.values());
		System.out.println("Cheapest Hotel for the given dates is");
		hotelCost.forEach((k, v) -> {
			if (v == low) {
				cheapList.put(k, v);
				System.out.println(k.getName() + ", Total Rates: $" + v);
			}
		});
		return cheapList;
	}

	public ArrayList<Hotel> findCheapestBestRatedHotel() throws InvalidInputException {
		Map<Hotel, Integer> cheapList = findCheapestHotel();
		ArrayList<Integer> ratingList = new ArrayList<Integer>();
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		cheapList.forEach((k, v) -> {
			ratingList.add(k.getRating());
		});
		int maxRating = Collections.max(ratingList);
		cheapList.forEach((k, v) -> {
			if (k.getRating() == maxRating) {
				list.add(k);
			}
		});
		list.stream().forEach(k -> System.out
				.println("Cheapest Best Rated Hotel is: \n" + k.getName() + ", Total Rates: $" + calcTotal(k)));
		return list;
	}

	public Map<Hotel, Integer> findBestRatedHotel() throws InvalidInputException {
		setPrices();
		System.out.println(hotelList);
		setDates();
		Map<Hotel, Integer> ratingMap = new HashMap<Hotel, Integer>();
		Map<Hotel, Integer> highestRatedMap = new HashMap<Hotel, Integer>();
		ratingMap = hotelList.stream().collect(Collectors.toMap(h -> h, h -> h.getRating()));
		int maxRating = Collections.max(ratingMap.values());
		ratingMap.forEach((k, v) -> {
			if (v == maxRating) {
				highestRatedMap.put(k, calcTotal(k));
			}
		});
		highestRatedMap.entrySet().stream().forEach(k -> System.out
				.println("Highest Rated Hotel is: \n" + k.getKey().getName() + ", Total Rates: $" + k.getValue()));

		return highestRatedMap;
	}

	public static void main(String[] args) {
		HotelReservation temp = new HotelReservation();
		try {
			temp.findCheapestBestRatedHotel();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}