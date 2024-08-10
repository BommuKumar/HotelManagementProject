package com.naresh.Database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Entity.Reservations;
import com.naresh.Database.Entity.Room;
import com.naresh.Database.Service.ReservationService;
import com.naresh.Database.customException.RoomAlreadyBooked;
import com.naresh.Database.customException.RoomNotExistedWithThisId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



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
    
       
       @PutMapping(path="cancel/reservation/{reservationId}")
       
         public ResponseEntity<String> cancelReservation(@PathVariable("reservationId") int reservationId) 
         {
             return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.cancelReservations(reservationId));
         }
        
       
       @GetMapping(path="get/rooms")
       
       public ResponseEntity<List<Room>> getAllRoomsByHotelName(@RequestParam("hotelName") String hotelName) 
       {
           return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.getallRoomsByHname(hotelName));
       }
      
       
       
       @GetMapping(path="get/avialable/rooms")
       
       public ResponseEntity<List<Room>> getAllAvailableRoomsByHotelName(@RequestParam("hotelName") String hotelName) 
       {
           return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.getallAvailableRoomsByHname(hotelName));
       }
       
     //  getTotalCostofRooms
       
       
       
       @GetMapping(path="get/total/cost")
       
       public ResponseEntity<Integer> getcostOfHotel(@RequestParam("hotelName") String hotelName) 
       {
           return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.getTotalCostofRooms(hotelName));
       } 
       

       @GetMapping(path="get/rooms/below")
       
      public ResponseEntity<List<Room>> getRoomsBelowPrice(@RequestParam("price") int price,@RequestParam("hotelName") String hotelName) 
       {
           return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.getRoomsBelowPrice(price,hotelName));
       }
       
       @GetMapping(path="get/rooms/with/discount")
       
       
       public ResponseEntity<List<Room>> getRoomsWith10PercentDis(@RequestParam("hotelName") String hotelName) 
       {
           return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.getRoomspricesWith10PercentDiscountOnMrp(hotelName));
       }
       
       
       @GetMapping(path="get/rooms/asc")
       
       
       public ResponseEntity<List<Room>> getRoomsInAscendingOrderofPrice(@RequestParam("hotelName") String hotelName) 
       {
           return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.getroomsAscBySortingOfPrice(hotelName));
       } 
       
      @GetMapping(path="get/rooms/dsc")  
       
       public ResponseEntity<List<Room>> getRoomsInDescendingOrderofPrice(@RequestParam("hotelName") String hotelName) 
       {
           return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.getroomsDscBySortingOfPrice(hotelName));
       } 
      @GetMapping(path="get/high/cost/room") 
      
      public ResponseEntity<Room> getHighCostOfRoom(@RequestParam("hotelName") String hotelName) 
      {
          return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.getHighCostRoom(hotelName));
      } 
      
     
      
}


