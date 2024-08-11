package com.naresh.Database;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HotelController {
	@Autowired
	HotelService hotelService;
	
	@PostMapping(path="add/hotel/with/meta")
	public ResponseEntity<?> addHotel(@RequestParam("hotel")String hotel,@RequestParam("file") MultipartFile file) throws IOException
	{
		
		System.out.println(hotel);
	    ObjectMapper objectMapper = new ObjectMapper();
		
	    Hotel hotelinfo=objectMapper.readValue(hotel,Hotel.class);
		
	    System.out.println(hotelinfo);
	    
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.addHotelWithMetaData(hotelinfo, file));
		
	}
	
	@GetMapping("get/hotel/pics")
	public ResponseEntity<Path> getMethodName(@RequestParam("hotelName") String hotelName) throws IOException {
		 
		
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelPics(hotelName));
	}
	

}
