package com.naresh.Database.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.Entity.Hotel;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	com.naresh.Database.Repository.HotelRepository hotelRepository;
	
	
	@Override
	public String addHotel(Hotel hotel) {
		 
		
		if(hotel.getRoom()!=null&&!hotel.getRoom().isEmpty())
		{
			hotel.getRoom().stream().forEach(room->room.setHotel(hotel));
		}
		
		hotelRepository.save(hotel);
		return "hotel added successfully";
	}

	 
}
