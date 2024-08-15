package com.naresh.Database.Service;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.Repository.HotelRepository;

@Service
public class ProcedureService {
	
	@Autowired
	HotelRepository hotelRepository;
	
	public String updateRoomPricesUsingProcedure(String hotelName,int pricePer)
	{
		   hotelRepository.updateRoomPricesUsingProcedure(hotelName, pricePer);
		
		 return "rooms prices updated sucessfully in hotel"+hotelName;
	} 
	 
	public BigDecimal getHotelRoomsTotalPrice(String hotelName)
	{
		
		 // int[] res=new int[1];
		  
		AtomicReference<BigDecimal> totalHotelCost = new AtomicReference<>();	
		
		   hotelRepository.getHotelRoomsCosts(hotelName,totalHotelCost);
		
		 return totalHotelCost.get();
	} 
	 
}
