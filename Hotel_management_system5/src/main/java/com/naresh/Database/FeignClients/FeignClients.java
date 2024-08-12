package com.naresh.Database.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//http://localhost:7727/Hotels/get/all/available
@FeignClient(name="HotelManagement",url = "http://localhost:7727")
public interface FeignClients {
	
	
	
	@GetMapping(path="Hotels/get/all/available")
	public ResponseEntity<List<Integer>> getAllAvailableRooms();

}
