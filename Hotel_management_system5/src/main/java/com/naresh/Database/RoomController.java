package com.naresh.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Entity.Reservations;
import com.naresh.Database.Entity.Room;
import com.naresh.Database.Repository.ReservationsRepository;
import com.naresh.Database.Service.HotelService;
import com.naresh.Database.Service.ReservationService;
import com.naresh.Database.Service.RoomService;
import com.naresh.Database.customException.HotelNotExistedWithThisId;
import com.naresh.Database.customException.RoomAlreadyBooked;
import com.naresh.Database.customException.RoomNotExistedWithThisId;


@RestController
public class RoomController {
	
	@Autowired
	ReservationService reservationService;
	 
	@Autowired
	RoomService  roomService;
	
	
	@PostMapping(path="add/room/{hotelId}")
	public ResponseEntity<String> addRoom(@RequestBody Room room,@PathVariable("hotelId") int hoteId)
	{ 
		try 
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(roomService.addRooms(room,hoteId));
	}
	catch(HotelNotExistedWithThisId ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

	}
   }
	
	 

	 
	 

}
