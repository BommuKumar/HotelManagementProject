package com.naresh.Database.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.Dto.HotelWithNoOfRooms;
import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Repository.HotelRepository;

@Service

public class NativeServiceImpl {
	
	@Autowired
 	HotelRepository hotelRepository;
	
	
 	public List<Hotel> getAllHotelsWithTheirRooms()
 	{
		
 		return hotelRepository.getAllHotelWithTheirRooms();
 		 
 		
 	}
	
	
 	public List<Hotel> getAllHotelsWithoutTheirRooms()
 	{
		
 		return hotelRepository.getHotelsWithoutRooms();
 		 
 		
 	}
 	
 	public  List<HotelWithNoOfRooms> getAllHotelsWithNoOfRooms()
 	{
		
 		List<Object[]> results= hotelRepository.getHotelsWithNoOfRooms();
 		
 		
 		List<HotelWithNoOfRooms> result= new ArrayList<HotelWithNoOfRooms>();
 		
		if (!results.isEmpty()) {
			
			for (Object[] res : results) {
				 
				
		       int  secondValue = ((Number) res[1]).intValue();

		       result.add( new HotelWithNoOfRooms(res[0].toString(), secondValue));
				
			}
		}
 		
		return result;
 	}
	
 	 

}
