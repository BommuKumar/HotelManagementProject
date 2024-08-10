package com.naresh.Database.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.FeignClients.FeignClients;

@Service
public class FeignClientService {
	
	@Autowired
	FeignClients feignClients;
	

	
	public List<Integer>  getAllAvailableRooms()
	{
		return  feignClients.getAllAvailableRooms().getBody();
		
	}
	
	
	
}
