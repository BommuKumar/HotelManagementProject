package com.naresh.Database;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Dto.AllHotelsNoOfRoomsReservationsDto;
import com.naresh.Database.Dto.HotelReservationsDto;
import com.naresh.Database.Dto.HotelReservationsInSpecificDateRange;
import com.naresh.Database.Dto.HotelWithNoOfRooms;
import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Entity.Reservations;
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
	
	
	@GetMapping(path="get/reservations")
	public ResponseEntity< List<HotelReservationsDto>> getAllReservationsOfSpecificHotel(@RequestParam("hotelName") String hotelName)
	{
		return ResponseEntity.status(HttpStatus.OK).body(nativeServiceImpl.getAllReservatoionsOfSpecificHotel(hotelName));
		
	}  
	
	@GetMapping(path="get/all/hotel/reservations")
	public ResponseEntity< List<AllHotelsNoOfRoomsReservationsDto>> getAllHotelsWithRoomsAndReservations()
	{
		return ResponseEntity.status(HttpStatus.OK).body(nativeServiceImpl.getAllHotelwithNoOfRoomsRes());
		
	}
	
	
	@GetMapping(path="get/reservations/{hotelName}")
	public ResponseEntity< List<HotelReservationsInSpecificDateRange>> getHotelReservationsInSpecificDateRange(@PathVariable String hotelName,@RequestParam LocalDate checkInFrom,@RequestParam LocalDate checkInTo)
	{
		return ResponseEntity.status(HttpStatus.OK).body(nativeServiceImpl.getHotelReservationsInSpecificDateRange(hotelName,checkInFrom,checkInTo));
		
	}


}
