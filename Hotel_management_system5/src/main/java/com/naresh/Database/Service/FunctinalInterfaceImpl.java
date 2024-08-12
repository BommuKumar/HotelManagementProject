package com.naresh.Database.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.Entity.Room;
 
import com.naresh.Database.Repository.RoomRepository;

@Service
public class FunctinalInterfaceImpl{
 
	
	 
	RoomRepository roomRepository;
	  
	  
	  @Autowired 
	public FunctinalInterfaceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}



	public List<Room> getBookedRooms(String hotelNames)
	{
		  FunctinalInterface  functinalInterface=hotelName-> roomRepository.getAllBookedRooms(hotelName);
	    
	    
	    return functinalInterface.getttingBookedRooms(hotelNames);
	}

}
