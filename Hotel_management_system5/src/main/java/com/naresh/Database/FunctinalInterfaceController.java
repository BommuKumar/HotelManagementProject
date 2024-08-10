package com.naresh.Database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Entity.Room;

@RestController
public class FunctinalInterfaceController {

	@Autowired
	com.naresh.Database.Service.FunctinalInterfaceImpl functinalInterfaceImpl;
	
	@GetMapping(path="get/booked/rooms")
	public ResponseEntity<List<Room>> getAllBookedRooms(@RequestParam("hotelName") String hotelName) {
		
	 	
		return   ResponseEntity.status(HttpStatus.OK).body(functinalInterfaceImpl.getBookedRooms(hotelName));
	}
	
	
	
	
}
