package com.naresh.Database.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.naresh.Database.customException.*;
import com.naresh.Database.Dto.HotelInfoDataInterfaceProjection;
import com.naresh.Database.Dto.HotelInfoDto;
import com.naresh.Database.Dto.HotelWithRoomsInfoDto;
import com.naresh.Database.Dto.RoomInfoDto;
import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Repository.HotelRepository;
import com.naresh.Database.customException.HotelNotFoundWithName;

@Service
public class PojectionsImpl {
     @Autowired 
	HotelRepository hotelRepository;
     
     // ***** Common **
     
     public List<RoomInfoDto> getRoomsInfo(String hotelName)
     {
    	 
    	 
    	 List<Object[]> result=hotelRepository.FindRoomsInfo(hotelName);
    	 
    	 
    	 List<RoomInfoDto> roomsInfo=new ArrayList<>();
    	 
    	 
    	 for(Object[] res:result)
    	 { 
    		 String roomType = res[0].toString();
    		 
    	        int price = Integer.parseInt(res[1].toString());

    	         
    	        roomsInfo.add(new RoomInfoDto(roomType, price));
    	 }
    	 
		return roomsInfo;
    	 
     }
     
    
     
   	// Native dto and  
     
	public 	HotelWithRoomsInfoDto getHotelInfo(String hotelName)
	{
	 	 
		List<Object[]> res= hotelRepository.findByHotelInfoforNativeDto(hotelName);
		
		if(res.isEmpty())
		{
			throw new HotelNotFoundWithName(hotelName);
		}
		
		Object[] result=res.get(0);
		
		HotelInfoDto hotelInfoDto= new HotelInfoDto(result[0].toString(),result[1].toString());
		
		List<RoomInfoDto> RoomsInfoDto  =getRoomsInfo(hotelName);
		
		
		 return new HotelWithRoomsInfoDto(hotelInfoDto,RoomsInfoDto);
		
	}
	
	// Jpql  dto 
	
	public  HotelWithRoomsInfoDto getHotelInfoByJpqlDto(String hotelName)
	{
		
		
		HotelInfoDto hotelInfoDto=   hotelRepository.findByHotelInfoforJPQLDto(hotelName);
		List<RoomInfoDto> RoomsInfoDto  =getRoomsInfo(hotelName);
		
		
		 return new HotelWithRoomsInfoDto(hotelInfoDto,RoomsInfoDto);
		  
		
	}
	
	// Jpql  inteface projections 
	
	public  HotelInfoDataInterfaceProjection getHotelInfoByJpqlInterfaceProjection(String hotelName)
	{
		
		
		return  hotelRepository.findByHotelInfoforJPQLInterfaceBasedProjection(hotelName);
		
		
	}
	
	
	
	
	
}
