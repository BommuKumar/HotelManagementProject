package com.naresh.Database.Dto;

public class HotelReservationsInSpecificDateRange {
	
	private String hotelName;
	
	private int ReservationId;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getReservationId() {
		return ReservationId;
	}

	public void setReservationId(int reservationId) {
		ReservationId = reservationId;
	}

	@Override
	public String toString() {
		return "HotelReservationsInSpecificDateRange [hotelName=" + hotelName + ", ReservationId=" + ReservationId
				+ "]";
	}

	public HotelReservationsInSpecificDateRange() {
		super();
	}

	public HotelReservationsInSpecificDateRange(String hotelName, int reservationId) {
		super();
		this.hotelName = hotelName;
		ReservationId = reservationId;
	}
	
	

}
