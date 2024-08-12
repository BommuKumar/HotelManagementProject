package com.naresh.Database.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.FeignClients.FeignClients;

@Service
public class FeignClientService {
	
	 
	FeignClients feignClients;
	

	@Autowired
	public FeignClientService(FeignClients feignClients) {
		super();
		this.feignClients = feignClients;
	}



	public List<Integer>  getAllAvailableRooms()
	{
		return  feignClients.getAllAvailableRooms().getBody();
		
	}
	
	
	
}
