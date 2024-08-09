package com.naresh.Database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Entity.Reservations;
import com.naresh.Database.Service.ReservationService;
import com.naresh.Database.customException.RoomAlreadyBooked;
import com.naresh.Database.customException.RoomNotExistedWithThisId;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class ReservationsController {
	
	
	@Autowired
	ReservationService reservationService;
	
	
    @PostMapping(path="book/room")
	 
	 public ResponseEntity<String> bookYourRoom(@RequestBody Reservations reservations,@RequestParam("roomId") int roomId)
	 {
		 
		 try
		 {
			return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.bookRoom(reservations, roomId));
				
		 }catch(RoomNotExistedWithThisId ex)
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).header("msg","hi").body(ex.getMessage());
		 }
		 catch(RoomAlreadyBooked ex)
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).header("msg","hi").body(ex.getMessage());

		 }
	   } 
    
    
       @GetMapping(path="get/all/available")
       public ResponseEntity<List<Integer>> getAllAvailableRooms() {
     
    	return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.getAvailableRooms());
        }
    

}
