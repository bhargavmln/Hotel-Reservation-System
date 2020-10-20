package com.capgemini.hotel;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class HotelReservationTest {

	@Test
	public void givendetailsOf3Hotels_WhenAddedToHotelList_SizeOfListIs3() {
		HotelReservation temp = new HotelReservation();
		Hotel lakeWood = new Hotel("Lakewood", 110);
		Hotel bridgeWood = new Hotel("Bridgewood", 160);
		Hotel ridgeWood = new Hotel("Ridgewood", 220);
		ArrayList<Hotel> list = temp.getHotelList();
		list.add(lakeWood);
		list.add(bridgeWood);
		list.add(ridgeWood);
		Assert.assertEquals(3, list.size());

		Assert.assertEquals("Lakewood", temp.findCheapestHotel());
	}
}
