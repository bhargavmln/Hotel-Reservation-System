package com.capgemini.hotel;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void givendetailsOf3Hotels_WhenAddedToHotelList_SizeOfListIs3(){
		HotelReservation temp = new HotelReservation();
		temp.addHotel("Lakewood",110,90);
		temp.addHotel("Bridgewood",160,50);
		temp.addHotel("Ridgewood",220,150);
		Assert.assertEquals(3, temp.hotelList.size());
	}
	
	@Test
	public void givendetailsOf3Hotels_WhenCorrect_ShouldReturnHotelNameWithLowRate() {
		HotelReservation temp = new HotelReservation();
		temp.addHotel("Lakewood",110,90);
		temp.addHotel("Bridgewood",160,50);
		temp.addHotel("Ridgewood",220,150);
		Assert.assertEquals("Lakewood",temp.findCheapestHotel());
	}
}
