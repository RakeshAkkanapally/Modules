package com.M62.util;

import java.util.ArrayList;

public class Flight {

	private String Type;
	private ArrayList<FlightDetails> Flights =new ArrayList<FlightDetails>();
	
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public ArrayList<FlightDetails> getFlights() {
		return Flights;
	}
	public void addFlights(FlightDetails toFlightDetails) {
		Flights.add(toFlightDetails);
	}
	
	
}
