package com.naresh.Database.Dto;

import java.util.List;

public class HotelWithRoomsInfoDto {
	

	 private HotelInfoDto hotelInfoDto;
	 
	
    private List<RoomInfoDto> roomInfoDto;



	 
	 

 


	@Override
	public String toString() {
		return "HotelWithRoomsInfoDto [hotelInfoDto=" + hotelInfoDto + ", roomInfoDto=" + roomInfoDto + "]";
	}









	public HotelWithRoomsInfoDto(HotelInfoDto hotelInfoDto, List<RoomInfoDto> roomInfoDto) {
		super();
		this.hotelInfoDto = hotelInfoDto;
		this.roomInfoDto = roomInfoDto;
	}









	public HotelInfoDto getHotelInfoDto() {
		return hotelInfoDto;
	}









	public void setHotelInfoDto(HotelInfoDto hotelInfoDto) {
		this.hotelInfoDto = hotelInfoDto;
	}









	public List<RoomInfoDto> getRoomInfoDto() {
		return roomInfoDto;
	}









	public void setRoomInfoDto(List<RoomInfoDto> roomInfoDto) {
		this.roomInfoDto = roomInfoDto;
	}









	public HotelWithRoomsInfoDto() {
		super();
	}


 

}
