package com.naresh.Database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Dto.HotelInfoDataInterfaceProjection;
 import com.naresh.Database.Dto.HotelWithRoomsInfoDto;
import com.naresh.Database.Dto.RoomInfoDto;
 
import com.naresh.Database.Service.PojectionsImpl;

@RestController
public class ProjectionsController {
	
	@Autowired
	PojectionsImpl pojectionsImpl;
	
	
	// common
	
  
	
	
	@GetMapping(path="get/rooms/info")
	public ResponseEntity<List<RoomInfoDto>>  getRoomsInfo(@RequestParam("hotelName") String hotelName)
	{
		return ResponseEntity.status(HttpStatus.OK).body(pojectionsImpl.getRoomsInfo(hotelName));
	}
	
	
	
	
	
	@GetMapping(path="native/dto/get/hotel/info")
	public ResponseEntity<HotelWithRoomsInfoDto>  getHotelInfoByNativeDto(@RequestParam("hotelName") String hotelName)
	{
		return ResponseEntity.status(HttpStatus.OK).body(pojectionsImpl.getHotelInfo(hotelName));
	}
	 
	
	@GetMapping(path="jpql/dto/get/hotel/info")
	public ResponseEntity<HotelWithRoomsInfoDto>  getHotelInfoByJPQLDto(@RequestParam("hotelName") String hotelName)
	{
		return ResponseEntity.status(HttpStatus.OK).body(pojectionsImpl.getHotelInfoByJpqlDto(hotelName));
	}
	
	//getHotelInfoByJpqlInterfaceProjection
	

	@GetMapping(path="jpql/interface/get/hotel/info")
	
	public ResponseEntity<HotelInfoDataInterfaceProjection>  getHotelInfoByJPQLInterfaceBasedProjections(@RequestParam("hotelName") String hotelName)
	{
		return ResponseEntity.status(HttpStatus.OK).body(pojectionsImpl.getHotelInfoByJpqlInterfaceProjection(hotelName));
	}
	
}
