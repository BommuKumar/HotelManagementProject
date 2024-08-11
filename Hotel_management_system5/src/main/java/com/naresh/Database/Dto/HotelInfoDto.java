package com.naresh.Database.Dto;

public class HotelInfoDto {
	
	
	private String hotelName;
	
	
	private String address;


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
 


	 


	 

	 
 


	public HotelInfoDto(String hotelName, String address) {
		super();
		this.hotelName = hotelName;
		this.address = address;
	}


	@Override
	public String toString() {
		return "HotelNameAndPriceDto [hotelName=" + hotelName + ", address=" + address + "]";
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public HotelInfoDto() {
		super();
	}
	
	
	

}
