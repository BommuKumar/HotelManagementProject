package com.naresh.Database.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.Entity.Reservations;
import com.naresh.Database.Entity.Room;
import com.naresh.Database.Repository.ReservationsRepository;
import com.naresh.Database.Repository.HotelRepository;
import com.naresh.Database.Repository.RoomRepository;
import com.naresh.Database.customException.RoomAlreadyBooked;
import com.naresh.Database.customException.RoomNotExistedWithThisId;


@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	ReservationsRepository reservationsRepository;
	
	@Autowired
	 HotelRepository HotelRepository;
	
	@Autowired
	RoomRepository  roomRepository;
	
	 

	@Override
	public String bookRoom(Reservations reservations,int roomId) {

	
		 if(!roomRepository.existsById(roomId))
		  {
			  throw new RoomNotExistedWithThisId("room not existed with id"+roomId+"please select existed room");
		  }
		 
		Room room=roomRepository.isRoomAvailable(roomId);
		
		
		System.out.println(room);
		
         if(room==null)
         {
        	 throw new RoomAlreadyBooked("room already booked");
         }
		
         else
         {
		  
		reservations.setRoom(new Room(roomId));
		
		reservationsRepository.save(reservations);
         
		
		String  hotelName=roomRepository.findById(roomId).get().getHotel().getHotelName();
		
		
		room.setAvailability("Booked");
		
		roomRepository.save(room);
		
		return "room is booked sucessfully in"+hotelName;
	}}


	@Override
	public List<Integer> getAvailableRooms() {
	   
		 
		
		List<Room> rooms=roomRepository.getAllAvailableRooms();
		
		List<Integer> availableRooms=rooms.stream().map(room->room.getRoomId()).collect(Collectors.toList());
		
		
		return availableRooms;
	}

}
