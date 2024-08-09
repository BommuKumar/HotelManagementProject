package com.naresh.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Service.HotelService;

@RestController
public class HotelController {
	@Autowired
	HotelService hotelService;
	
	@PostMapping(path="add/hotel")
	public ResponseEntity<?> addHotel(@RequestBody Hotel hotel)
	{
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.addHotel(hotel));
		
	}

}
