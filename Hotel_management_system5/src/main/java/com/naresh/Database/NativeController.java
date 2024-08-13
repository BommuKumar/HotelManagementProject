package com.naresh.Database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Dto.HotelWithNoOfRooms;
import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Service.NativeServiceImpl;

@RestController
@RequestMapping(path="native")
public class NativeController {
	
	@Autowired
	NativeServiceImpl nativeServiceImpl;
	
	@GetMapping(path="get/hotels/with/rooms")
	public ResponseEntity<List<Hotel>> getHotelWithTheirRooms()
	{
		return ResponseEntity.status(HttpStatus.OK).body(nativeServiceImpl.getAllHotelsWithTheirRooms());
		
	}
	
	@GetMapping(path="get/hotels/withOut/rooms")
	public ResponseEntity<List<Hotel>> getHotelWithoutTheirRooms()
	{
		return ResponseEntity.status(HttpStatus.OK).body(nativeServiceImpl.getAllHotelsWithoutTheirRooms());
		
	}
//getAllHotelsWithNoOfRooms
	
	@GetMapping(path="get/hotels/with/noOf/rooms")
	public ResponseEntity< List<HotelWithNoOfRooms>> getHotelWithNoOfRooms()
	{
		return ResponseEntity.status(HttpStatus.OK).body(nativeServiceImpl.getAllHotelsWithNoOfRooms());
		
	}

}
