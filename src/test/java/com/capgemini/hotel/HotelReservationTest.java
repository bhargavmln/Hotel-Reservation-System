package com.capgemini.hotel;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void givendetailsOf3Hotels_WhenAddedToHotelList_SizeOfListIs3() {
		HotelReservation temp = new HotelReservation();
		temp.addHotel("Lakewood", 110, 90, 3);
		temp.addHotel("Bridgewood", 150, 50, 4);
		temp.addHotel("Ridgewood", 220, 150, 5);
		Assert.assertEquals(3, temp.hotelList.size());
	}

	@Test
	public void givendetailsOf3Hotels_WhenCorrect_ShouldReturnHotelNameWithLowRate() {
		HotelReservation temp = new HotelReservation();
		temp.addHotel("Lakewood", 110, 90, 3);
		temp.addHotel("Bridgewood", 150, 50, 4);
		temp.addHotel("Ridgewood", 220, 150, 5);
		Hotel hotel = temp.findCheapestBestRatedHotel();
		Assert.assertEquals(hotel.getName(), "Bridgewood");
	}
}
