package com.naresh.Database;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.naresh.Database.Service.HotelService;

@RestController
public class FilesController {
	
	@Autowired
	HotelService hotelService;
	
	@PostMapping(path="add/hotel/metaData")
	
	public ResponseEntity<String>  addHotelMetaData(@RequestParam("file") MultipartFile file,@RequestParam("hotelId") int hoteId) throws IOException
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.addOnlyHotelMetaData(file, hoteId));	
	}

}
