package com.naresh.Database.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.Repository.HotelRepository;
import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Entity.Room;
import com.naresh.Database.Repository.RoomRepository;
import com.naresh.Database.customException.HotelNotExistedWithThisId;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	RoomRepository roomRepository;

	@Autowired
	 HotelRepository hotelRepository;
	
	
	@Override
	public String addRooms(Room room,int hoteId) {

		
		
		if(!hotelRepository.existsById(hoteId))
		{
			throw new HotelNotExistedWithThisId("hotel not existed with this name :"+hoteId);
		}
		
		room.setHotel(new Hotel(hoteId));
		roomRepository.save(room);
		
		return "romm added sucessfully";
		
	}

}
