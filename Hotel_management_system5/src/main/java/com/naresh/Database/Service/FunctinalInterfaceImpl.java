package com.naresh.Database.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.Entity.Room;
import com.naresh.Database.Repository.ReservationsRepository;
import com.naresh.Database.Repository.RoomRepository;

@Service
public class FunctinalInterfaceImpl{
 
	
	  @Autowired 
	RoomRepository roomRepository;
	
	public List<Room> getBookedRooms(String hotelNames)
	{
		  FunctinalInterface  functinalInterface=(hotelName)->
	    {
		return roomRepository.getAllBookedRooms(hotelName);
	    };
	    
	    return functinalInterface.getttingBookedRooms(hotelNames);
	}

}
