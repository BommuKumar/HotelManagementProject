package com.naresh.Database.Service;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

import com.naresh.Database.Entity.Hotel;

public interface HotelService {
	
	
	public abstract String addHotelWithMetaData(Hotel hotel,MultipartFile file)  throws IOException;
	
	public abstract String addOnlyHotelMetaData(MultipartFile file,int hotelId) throws IOException;

	public   Path getHotelPics(String hotelName) throws IOException;

}
