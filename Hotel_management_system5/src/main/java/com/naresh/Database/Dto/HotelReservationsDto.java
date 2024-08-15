package com.naresh.Database.Dto;

import java.time.LocalDate;

import com.naresh.Database.Entity.Room;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class HotelReservationsDto {
	
   private int  reservationId;
	               
	
	private String guestName;
	
	 private LocalDate  checkInDate;
	 
	 private LocalDate checkOutDate;
	 
	 
	 private String isCancelled;


	public int getReservationId() {
		return reservationId;
	}


	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}


	public String getGuestName() {
		return guestName;
	}


	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}


	public LocalDate getCheckInDate() {
		return checkInDate;
	}


	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}


	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}


	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}


	public String getIsCancelled() {
		return isCancelled;
	}


	public void setIsCancelled(String isCancelled) {
		this.isCancelled = isCancelled;
	}


	@Override
	public String toString() {
		return "HotelReservationsDto [reservationId=" + reservationId + ", guestName=" + guestName + ", checkInDate="
				+ checkInDate + ", checkOutDate=" + checkOutDate + ", isCancelled=" + isCancelled + "]";
	}


	public HotelReservationsDto(int reservationId, String guestName, LocalDate checkInDate, LocalDate checkOutDate,
			String isCancelled) {
		super();
		this.reservationId = reservationId;
		this.guestName = guestName;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.isCancelled = isCancelled;
	}


	public HotelReservationsDto() {
		super();
	}
	 
	 
//	 
//	// @JsonIgnore
//
//		@ManyToOne
//		 @JoinColumn(name="Room_id")
//		 private Room room;
//		  

}
