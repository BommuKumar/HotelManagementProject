package com.naresh.Database.Dto;

public class HotelWithNoOfRooms {
	
	private  String hotelName;
	
	
	private int noOfRooms;


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public int getNoOfRooms() {
		return noOfRooms;
	}


	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}


	@Override
	public String toString() {
		return "HotelWithNoOfRooms [hotelName=" + hotelName + ", noOfRooms=" + noOfRooms + "]";
	}


	public HotelWithNoOfRooms() {
		super();
	}


	public HotelWithNoOfRooms(String hotelName, int noOfRooms) {
		super();
		this.hotelName = hotelName;
		this.noOfRooms = noOfRooms;
	}
	
	

}
