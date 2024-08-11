package com.naresh.Database.Dto;

public class RoomInfoDto {

    private String roomType;
	
	
	 private int  price;


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


	public RoomInfoDto(String roomType, int price) {
		super();
		this.roomType = roomType;
		this.price = price;
	}


	public RoomInfoDto() {
		super();
	}


	@Override
	public String toString() {
		return "RoomInfoDto [roomType=" + roomType + ", price=" + price + "]";
	}
	 
	 

}
