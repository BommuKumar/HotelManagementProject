package com.naresh.Database.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Repository.HotelRepository;

@Service
public class GroupByClauseUsingStreams {
	
	
	
	@Autowired
	HotelRepository hotelRepository;
	
	   public List<Hotel> getAllHotelss()
	     {
		return  hotelRepository.findAll();
	 
			}
	
	public Map<Object,List<Hotel>> getAllHotels()
	{
		Map<Object,List<Hotel>> res= hotelRepository.findAll().stream().collect(Collectors.groupingBy(hotel->hotel.getHotelName()));
	return res;
			}
	
	

	public Map<Object,List<String>> getAllHotelsWithAddress()
	{
		Map<Object,List<String>> res= hotelRepository.findAll().stream().collect(Collectors.groupingBy(hotel->hotel.getHotelName(),Collectors.mapping(hotel->hotel.getAddress(), Collectors.toList())));
	    return res;
	}
	 
	
	public Map<Object,Long> getAllHotelsWithRooms()
	{
		Map<Object,Long> res= hotelRepository.findAll().stream().collect(Collectors.groupingBy(hotel->hotel.getHotelName(),Collectors.summingLong(hotel->hotel.getRoom().size())));
      	return res;
	
			}
	
	public Map<Object,Long> getAllHotelsWithRoomsSumPrice()
	{
		Map<Object,Long> res= hotelRepository.findAll().stream().collect(Collectors.groupingBy(hotel->hotel.getHotelName(),
				
				          Collectors.summingLong(hotel->hotel.getRoom().stream().mapToLong(room->room.getPrice()).sum())
				
				                ));
      	return res;
	
			}
	 
     // **** Collecting And Then
	
	
	public Set<Hotel> getHotelsWithoutDuplicate()
	{ 
	   Set<Hotel> res=hotelRepository.findAll().stream().collect(Collectors.collectingAndThen(Collectors.toList(), list->new TreeSet<>(list)));
	
	return res;
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
