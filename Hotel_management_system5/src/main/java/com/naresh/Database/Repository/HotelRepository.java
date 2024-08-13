package com.naresh.Database.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.naresh.Database.Dto.HotelInfoDataInterfaceProjection;
import com.naresh.Database.Dto.HotelInfoDto;
import com.naresh.Database.Entity.Hotel;
 

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	
	
	// ***** common*****
	
	  @Query(value="select r.room_type , r.price from room r inner join hotel h "+"on r.hotel_id=h.hotel_id "+" where h.hotel_name=:hotelName",nativeQuery = true)
	  
	    List<Object[]>  FindRoomsInfo(@Param("hotelName") String hotelName);
	
	
	
	   public  Optional<Hotel> findByHotelName(String hotelName);
	  
	  public abstract Hotel findByHotelNameAndRoomAvailability(String hotelName,String availability);
	  
	  //  *native sql with Dto*
	  
		@Query(value="select h.hotel_name,h.address from hotel h where h.hotel_Name=:hotelName",nativeQuery = true)
	  
	  public  List<Object[]> findByHotelInfoforNativeDto(@Param("hotelName") String hotelName);
	    
	  // *jpql with Dto*
	 
		@Query(value="select new com.naresh.Database.Dto.HotelInfoDto(h.hotelName,h.address) from Hotel h where h.hotelName=:hotelName")
		  
		  public  HotelInfoDto findByHotelInfoforJPQLDto(@Param("hotelName") String hotelName);
	
		
		
		// *jpql with InterfaceBasedProjection*
		 
			@Query(value="select h.hotelName as hotelName,h.address as address from Hotel h where h.hotelName=:hotelName")
			  
			  public  HotelInfoDataInterfaceProjection findByHotelInfoforJPQLInterfaceBasedProjection(@Param("hotelName") String hotelName);
		
		
		//   complete native sql joins with different senarios??

     //Retrieve All Hotels with Their Rooms
			
		@Query(value="select h.*,r.room_id,r.price from hotel h left Join room r on h.hotel_Id=r.hotel_id",nativeQuery = true)
			
			public List<Hotel> getAllHotelWithTheirRooms();
		
		 
		
		
		
		
		
		//2. Retrieve Hotels Without Rooms	
		 
		@Query(value="select h.* from hotel h left join room r on h.hotel_id=r.hotel_id where r.Hotel_Id is Null",nativeQuery = true)
		public List<Hotel> getHotelsWithoutRooms();
			
			
			// 4. Count Rooms for Each Hotel
		

		@Query(value="select h.hotel_name,count(r.room_id) as no_of_rooms from hotel h left join room r on h.hotel_id=r.hotel_id group by h.hotel_name",nativeQuery = true)
		
		public  List<Object[]> getHotelsWithNoOfRooms();
			
			
			
			
			
			
		
		
		 
}
