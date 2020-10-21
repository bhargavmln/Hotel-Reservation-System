package com.capgemini.hotel;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void givendetailsOf3HotelsForRegularCustomer_WhenCorrect_ShouldReturnTrue() throws InvalidInputException {
		HotelReservation temp = new HotelReservation();
		ArrayList<Hotel> val = temp.findCheapestBestRatedHotel();
		Assert.assertEquals(temp.calcTotal(val.get(0)), 200);
	}
	
	@Test
	public void givendetailsOf3HotelsForRewardCustomer_WhenCorrect_ShouldReturnTrue() throws InvalidInputException {
		HotelReservation hotelResv=new HotelReservation();
		ArrayList<Hotel> val=hotelResv.findCheapestBestRatedHotel();
		Assert.assertEquals(hotelResv.calcTotal(val.get(0)),140);
	}

}
