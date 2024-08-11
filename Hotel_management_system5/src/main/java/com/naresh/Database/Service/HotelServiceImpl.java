package com.naresh.Database.Service;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Entity.HotelMetaData;
import com.naresh.Database.customException.HotelNotHaveAnyImages;
@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	com.naresh.Database.Repository.HotelRepository hotelRepository;
	
	
	@Override
	public String addHotelWithMetaData(Hotel hotel,MultipartFile file) throws IOException {
		 
		
		if(hotel.getRoom()!=null&&!hotel.getRoom().isEmpty())
		{
			hotel.getRoom().stream().forEach(room->room.setHotel(hotel));
		}
		
		// ** addOnlyHotelMetaData ***
		
		
		 String uploadDir="C:\\HotelPics";
		  
		  String fileName=file.getOriginalFilename();
		  
		  Path uploadpth=Paths.get(uploadDir);
		   
		  Path completePath=uploadpth.resolve(fileName);
		
		  
		  Files.copy(file.getInputStream(), completePath);
		
		 hotel.setHotelMetaData(new HotelMetaData(file.getOriginalFilename(), completePath.toString(), file.getSize()));

		
		hotelRepository.save(hotel);
		
		return "hotel added successfully";
	}


	@Override
	public String addOnlyHotelMetaData(MultipartFile file,int hotelId) throws IOException {

         
		Hotel hotel=hotelRepository.findById(hotelId).get();
		
		  String uploadDir="C:\\HotelPics";
		  
		  String fileName=file.getOriginalFilename();
		  
		  Path uploadpth=Paths.get(uploadDir);
		   
		  Path completePath=uploadpth.resolve(fileName);
		
		  
		  Files.copy(file.getInputStream(), completePath);
		
		
		
		 hotel.setHotelMetaData(new HotelMetaData(file.getOriginalFilename(), completePath.toString(), file.getSize()));
		
		
		hotelRepository.save(hotel);
		
		return "meta data uploaded successfully of hotel"+hotel.getHotelName();
	}


	@Override
	public Path getHotelPics(String hotelName) throws IOException {


		Hotel hotel=hotelRepository.findByHotelName(hotelName).get();

		
		if(hotel.getHotelMetaData()==null)
		{
			throw new HotelNotHaveAnyImages("hotel"+hotel.getHotelName()+"not contain any images");
		}
		
		
		String filePath=hotel.getHotelMetaData().getFilePath();
		
		
		Path sourcepath=Paths.get(filePath);
		
		 return sourcepath;
	 	 
	}

	 
}
