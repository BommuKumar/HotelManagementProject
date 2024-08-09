package com.naresh.Database.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="HOTEL")
public class Hotel {
	
	
	@Id
	private int hotelId;
	
	
	private String hotelName;
	
	private String address;
	
	
	private String phoneNumber;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "hotel")
	private List<Room> room;
	
	
	

	public Hotel(int hotelId) {
		super();
		this.hotelId = hotelId;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}


	public int getHotelId() {
		return hotelId;
	}


	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


 

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", room=" + room + "]";
	}


	public Hotel(int hotelId, String hotelName, String address, String phoneNumber, List<Room> room) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.room = room;
	}


	public Hotel() {
		super();
	}


	 
	
	
	

}
 