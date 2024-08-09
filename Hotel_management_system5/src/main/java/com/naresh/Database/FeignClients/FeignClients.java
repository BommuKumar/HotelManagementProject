package com.naresh.Database.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Hotel_management_system")
public interface FeignClients {
	
	@GetMapping(path="Hotels/get/all/available")
	public ResponseEntity<List<Integer>> getAllAvailableRooms();

}
