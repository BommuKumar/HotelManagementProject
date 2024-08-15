package com.naresh.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Service.ProcedureService;

@RestController
@RequestMapping("procedure")
public class ProcedureController {
	
	
	@Autowired
	ProcedureService ProcedureService;
	
	@PutMapping("update/price")
	public ResponseEntity<String>  upadteRoomsPricesOfHotel(@RequestParam("hotelName") String hotelName,@RequestParam("pricePer") int pricePer)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ProcedureService.updateRoomPricesUsingProcedure(hotelName, pricePer));
		
	} 
	 
	@GetMapping("get/total/price")
	public ResponseEntity<String>  getHotelRoomsPrice(@RequestParam("hotelName") String hotelName)
	{
		return ResponseEntity.status(HttpStatus.OK).body("total hotel cost is :"+ProcedureService.getHotelRoomsTotalPrice(hotelName));
		
	}
}
