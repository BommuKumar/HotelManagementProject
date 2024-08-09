package com.naresh.Database.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class FeignClientService {
	
	@Autowired
	com.naresh.Database.FeignClients.FeignClients feignClients;
	

	
	public List<Integer>  getAllAvailableRooms()
	{
		return  feignClients.getAllAvailableRooms().getBody();
		
	}
	
	
	
}
