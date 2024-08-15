package com.naresh.Database.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.Dto.AllHotelsNoOfRoomsReservationsDto;
import com.naresh.Database.Dto.HotelReservationsDto;
import com.naresh.Database.Dto.HotelReservationsInSpecificDateRange;
import com.naresh.Database.Dto.HotelWithNoOfRooms;
import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Entity.Reservations;
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
 	
 	// ** spl with three tables
 	
 	public List<HotelReservationsDto> getAllReservatoionsOfSpecificHotel(String hotelName)
 	{
 		List<Object[]> results= hotelRepository.getAllreservationsUnderSpecificHotel(hotelName);
 		
 		
 		List<HotelReservationsDto> result=new ArrayList<>();
 		for(Object[] res:results)
 		{
 			 int  id = ((Number) res[0]).intValue();
 	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

           String guestName=res[1].toString();
           LocalDate checkin = LocalDate.parse(res[2].toString(),formatter);
           LocalDate checkout = LocalDate.parse(res[3].toString(),formatter);
 			String isCancelled=res[4].toString();
 			
 			result.add(new HotelReservationsDto(id,guestName,checkin,checkout,isCancelled));
 		}
 		
 		return result;
 	}
 	
 	public List<AllHotelsNoOfRoomsReservationsDto>  getAllHotelwithNoOfRoomsRes()
 	{
 		return   hotelRepository.getAllHotelsRoomsAndReservations();

 	}
 	 
 	
	public List<HotelReservationsInSpecificDateRange>  getHotelReservationsInSpecificDateRange(String hotelName,LocalDate checkInFrom,LocalDate checkInTo)
 	{
		 List<HotelReservationsInSpecificDateRange> results=new ArrayList<>();
	  	 
 		List<Object[]> result=   hotelRepository.gettingReservationsinRangeDateforHotel(hotelName,checkInFrom,checkInTo);

 		
 	 	for(Object[] res:result)
 		{
 	 		 int  id = ((Number) res[1]).intValue();

 			results.add(new HotelReservationsInSpecificDateRange(res[0].toString(),id));
 		}
 	 	
 	 	return results;
 	}
	
 	 

}
