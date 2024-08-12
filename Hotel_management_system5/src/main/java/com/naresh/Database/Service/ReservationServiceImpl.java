package com.naresh.Database.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Entity.Reservations;
import com.naresh.Database.Entity.Room;
import com.naresh.Database.Repository.ReservationsRepository;
import com.naresh.Database.Repository.HotelRepository;
import com.naresh.Database.Repository.RoomRepository;
import com.naresh.Database.customException.ReservationNotFound;
import com.naresh.Database.customException.HotelNotFoundWithName;

import com.naresh.Database.customException.RoomAlreadyBooked;
import com.naresh.Database.customException.RoomNotExistedWithThisId;
import com.naresh.Database.customException.RoomsNotExistedInThisHotel;

import jakarta.transaction.Transactional;


@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	ReservationsRepository reservationsRepository;
	
	@Autowired
	 HotelRepository hotelRepository;
	
	@Autowired
	RoomRepository  roomRepository;
	
	 

	@Override
	public String bookRoom(Reservations reservations,int roomId) {

	
		
		
		  Room room=roomRepository.findById(roomId).orElseThrow(()->new RoomNotExistedWithThisId(""+roomId));
		 
		 
		Room rooms=roomRepository.isRoomAvailable(roomId);
		
		
		System.out.println(rooms);
		
         if(rooms==null)
         {
        	 throw new RoomAlreadyBooked("room already booked");
         }
		
         else
         {
		  
		reservations.setRoom(new Room(roomId));
		
		reservations.setIsCancelled("no");
		
		reservationsRepository.save(reservations);
         
		
		String  hotelName=room.getHotel().getHotelName();
		
		
		rooms.setAvailability("Booked");
		
		roomRepository.save(rooms);
		
		return "room is booked sucessfully in"+hotelName;
	}}


	@Override
	public List<Integer> getAvailableRooms() {
	   
		 
		
		List<Room> rooms=roomRepository.getAllAvailableRooms();
		
		List<Integer> availableRooms=rooms.stream().map(room->room.getRoomId()).collect(Collectors.toList());
		
		
		return availableRooms;
	}


	
	@Transactional
	@Override
	public String cancelReservations(int reservationId) {
		 
		
		Reservations  reservations =reservationsRepository.findById(reservationId).orElseThrow(()-> new ReservationNotFound("reservation not found with this id"+reservationId));	
		
		
		
		reservations.setIsCancelled("yes");
		
		
		reservationsRepository.save(reservations);
		
		
		
		Room room=roomRepository.findById(reservations.getRoom().getRoomId()).get();
		
		
		  room.setAvailability("Available");
		  
		  
		roomRepository.save(room);
		
		return "room cancelled successfully";
	}


	@Override
	public List<Room> getallRoomsByHname(String hotelName) {


		
		Hotel hotel=hotelRepository.findByHotelName(hotelName).get();
	
		
		if(hotel.getRoom().isEmpty())
		{
			throw new RoomsNotExistedInThisHotel("room not existed in this hotel"+hotelName);
		}
		else
		{
		
		return hotel.getRoom();
	   } 

	}

	// ****Streams**********\\// filter,maptoInt,foreach,sorted
	
	// map,distinct,maptolOng,mapToDouble,AnyMatch,sum(),min().max(),avg();

	@Override
	public List<Room> getallAvailableRoomsByHname(String hotelName) {


		
		Hotel hotel=hotelRepository.findByHotelNameAndRoomAvailability(hotelName,"Available");

		//System.out.println("fi");
		
		return hotel.getRoom().stream().filter(room->room.getAvailability().equals("Available")).collect(Collectors.toList());
		
	  
	}
 
	@Override
	public int getTotalCostofRooms(String hotelName) {


	 Hotel hotel=hotelRepository.findByHotelName(hotelName).orElseThrow(()->{
		 
		 return new HotelNotFoundWithName("Hotel NotFound With Name"+hotelName);
	 });
		
	if( hotel.getRoom().isEmpty())
	{
		throw new RoomsNotExistedInThisHotel("no rooms found in this hotel"+hotelName);
	}
	else
	{
		int total=hotel.getRoom().stream().mapToInt(room->{
			
			return room.getPrice();
		}).sum();
		
		return total;
	}
}


	@Override
	public List<Room> getRoomsBelowPrice(int price,String hotelName) {

     
		 Hotel hotel=hotelRepository.findByHotelName(hotelName).orElseThrow(()->{
			 
			 return new HotelNotFoundWithName("Hotel NotFound With Name"+hotelName);
		 });
		 if( hotel.getRoom().isEmpty())
			{
				throw new RoomsNotExistedInThisHotel("no rooms found in this hotel"+hotelName);
			}
		
		
		return  roomRepository.getRoomsBelowPrice(price, hotelName);
		
	 
	}

	
	
	@Override
	public List<Room> getRoomspricesWith10PercentDiscountOnMrp(String hotelName) {


		
    Hotel hotel=hotelRepository.findByHotelName(hotelName).orElseThrow(()->{
			 
			 return new HotelNotFoundWithName("Hotel NotFound With Name"+hotelName);
		 });
		
	 
     hotel.getRoom().stream().forEach(room->
    {
    	  room.setPrice((int)(room.getPrice()*(0.9)));
    	 
    });
	  	
		return hotel.getRoom();
	}


	@Override
	public List<Room> getroomsAscBySortingOfPrice(String hotelName) {


     Hotel hotel=hotelRepository.findByHotelName(hotelName).orElseThrow(()->{
			 
			 return new HotelNotFoundWithName("Hotel NotFound With Name"+hotelName);
		 });
     
     
      List<Room> sortedRooms= hotel.getRoom().stream().sorted(Comparator.comparingInt(Room::getPrice)).collect(Collectors.toList());
     
		
		
		return sortedRooms;
	}
		
	@Override
	public List<Room> getroomsDscBySortingOfPrice(String hotelName) {


     Hotel hotel=hotelRepository.findByHotelName(hotelName).orElseThrow(()->{
			 
			 return new HotelNotFoundWithName("Hotel NotFound With Name"+hotelName);
		 });
     
     
      List<Room> sortedRooms= hotel.getRoom().stream().sorted(Comparator.comparingInt(Room::getPrice).reversed()).collect(Collectors.toList());
     
		
		
		return sortedRooms;
	}
	@Override
	public Room getHighCostRoom(String hotelName)
	{
		

	     Hotel hotel=hotelRepository.findByHotelName(hotelName).orElseThrow(()->{
				 
				 return new HotelNotFoundWithName("Hotel NotFound With Name"+hotelName);
			 });
	     
	     
	    List<Room> room= hotel.getRoom().stream().sorted(Comparator.comparingInt(Room::getPrice)).collect(Collectors.toList());
	     
		return room.get(room.size()-1);
		
	}
	
	
	
	//
}

	
	
	
	
	
	
 
