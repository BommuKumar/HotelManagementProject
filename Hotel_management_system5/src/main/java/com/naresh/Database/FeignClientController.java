package com.naresh.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Service.FeignClientService;


@RestController
@RequestMapping(path="feign")
public class FeignClientController {

	@Autowired
	FeignClientService feignClientService;
	
	@GetMapping(path="get/all")
	public ResponseEntity<?> getAllRoomes()
	{
     return ResponseEntity.status(HttpStatus.OK).body(feignClientService.getAllAvailableRooms());
		
	}
}
