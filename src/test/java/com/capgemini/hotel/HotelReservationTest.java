package com.capgemini.hotel;

import org.junit.Assert;
import org.junit.Test;


public class HotelReservationTest {

	@Test
	public void givendetailsOf3Hotels_WhenAddedToHotelList_SizeOfListIs3(){
		
		HotelReservation.addHotel("Lakewood",110,90);
		HotelReservation.addHotel("Bridgewood",160,60);
		HotelReservation.addHotel("Ridgewood",220,150);
		Assert.assertEquals(3, HotelReservation.hotels.size());
	}
}
