package com.naresh.Database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
  
import com.naresh.Database.Service.FeignClientService;


@RestController
@RequestMapping(path="feign")
public class FeignClientController {

	
	FeignClientService feignClientService;
	
	
	@Autowired
	public FeignClientController(FeignClientService feignClientService) {
		super();
		this.feignClientService = feignClientService;
	}



	@GetMapping(path="get/all")
	public ResponseEntity<List<Integer>> getAllRoomes()
	{
     return ResponseEntity.status(HttpStatus.OK).body(feignClientService.getAllAvailableRooms());
		
	}
}
