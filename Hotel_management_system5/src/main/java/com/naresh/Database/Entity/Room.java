package com.naresh.Database.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ROOM")
public class Room {

	@Id
	private int roomId;
	
	
	private String roomNumber;
	
	
	private String roomType;
	
	
	
	private int  price;

	
	private String availability;
	
	
	@ManyToOne
	@JoinColumn(name="hotel_Id")
	private Hotel hotel;
	
	
	public Room(int roomId) {
		super();
		this.roomId = roomId;
	}


	@OneToMany(cascade = CascadeType.ALL,mappedBy="room")
	private List<Reservations> reservations;


 


	public Room(int roomId, String roomNumber, String roomType, int price, String availability, Hotel hotel,
			List<Reservations> reservations) {
		super();
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.price = price;
		this.availability = availability;
		this.hotel = hotel;
		this.reservations = reservations;
	}





	public String getAvailability() {
		return availability;
	}





	public void setAvailability(String availability) {
		this.availability = availability;
	}





	public Room() {
		super();
	}


	 


	public int getRoomId() {
		return roomId;
	}


	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}


	public String getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}


	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public Hotel getHotel() {
		return hotel;
	}

	 // @JsonProperty("hotelId")
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public List<Reservations> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservations> reservations) {
		this.reservations = reservations;
	}
	
	


 

	 






	 
	
}
 