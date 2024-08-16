package com.naresh.Database;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Service.GroupByClauseUsingStreams;

@RestController
@RequestMapping("group")

public class StreamsGroupByController {
	
	@Autowired
	GroupByClauseUsingStreams groupByClauseUsingStreams;
	
	
	@GetMapping("get/hotel/info")
	
	public ResponseEntity<Map<Object,List<Hotel>>> getAllHotelInfo()
	{
		return ResponseEntity.status(HttpStatus.OK).body(groupByClauseUsingStreams.getAllHotels());
	} 
	
	@GetMapping("get/hotel/infos")
	
	public ResponseEntity<List<Hotel>> getAllHotelInfos()
	{
		return ResponseEntity.status(HttpStatus.OK).body(groupByClauseUsingStreams.getAllHotelss());
	}
	
    @GetMapping("get/hotel/address")
	
	public ResponseEntity<Map<Object, List<String>>> getAllHotelInfosAddress()
	{
		return ResponseEntity.status(HttpStatus.OK).body(groupByClauseUsingStreams.getAllHotelsWithAddress());
	}
	
	
	
	
	
	@GetMapping("get/hotel/rooms/info")
	public ResponseEntity<Map<Object, Long>> getAllHotelInfowithRooms()
	{
		return ResponseEntity.status(HttpStatus.OK).body(groupByClauseUsingStreams.getAllHotelsWithRooms());
	}

	@GetMapping("get/hotel/rooms/sum/price")
	public ResponseEntity<Map<Object, Long>> getAllHotelInfowithRoomsSumPrice()
	{
		return ResponseEntity.status(HttpStatus.OK).body(groupByClauseUsingStreams.getAllHotelsWithRoomsSumPrice());
	} 

	@GetMapping("get/hotel/without/duplicates")
	public ResponseEntity<Set<Hotel>> getHotelsWithoutDuplicate()
	{
		return ResponseEntity.status(HttpStatus.OK).body(groupByClauseUsingStreams.getHotelsWithoutDuplicate());
	}

}
