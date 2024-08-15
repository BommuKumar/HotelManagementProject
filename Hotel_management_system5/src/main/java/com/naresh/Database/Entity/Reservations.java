package com.naresh.Database.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="RESERVATION")
public class Reservations {

	
	@Id
	@SequenceGenerator(name = "reserv_seq_gen",sequenceName = "reserv_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reserv_seq_gen")
	private int  reservationId;
	               
	
	private String guestName;
	
	 private LocalDate  checkInDate;
	 
	 private LocalDate checkOutDate;
	 
	 
	 private String isCancelled;
	 
	 
	 
	// @JsonIgnore

		@ManyToOne
		 @JoinColumn(name="Room_id")
		 private Room room;
		  
	 
	 
	 public String getIsCancelled() {
		return isCancelled;
	}
	public void setIsCancelled(String isCancelled) {
		this.isCancelled = isCancelled;
	}






 
 
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

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}








	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}








	public Room getRoom() {
		return room;
	}








	public void setRoom(Room room) {
		this.room = room;
	}







 



 



	public Reservations(int reservationId, String guestName, LocalDate checkInDate, LocalDate checkOutDate,
			String isCancelled, Room room) {
		super();
		this.reservationId = reservationId;
		this.guestName = guestName;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.isCancelled = isCancelled;
		this.room = room;
	}
	@Override
	public String toString() {
		return "Reservations [reservationId=" + reservationId + ", guestName=" + guestName + ", checkInDate="
				+ checkInDate + ", checkOutDate=" + checkOutDate + ", isCancelled=" + isCancelled + ", room=" + room
				+ "]";
	}
	public LocalDate getCheckInDate() {
		return checkInDate;
	}

 
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}








	public Reservations() {
		super();
	}
	 
	 
	
	
}
