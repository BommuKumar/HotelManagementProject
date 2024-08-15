package com.naresh.Database.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.naresh.Database.Dto.AllHotelsNoOfRoomsReservationsDto;
import com.naresh.Database.Dto.HotelInfoDataInterfaceProjection;
import com.naresh.Database.Dto.HotelInfoDto;
import com.naresh.Database.Dto.HotelReservationsDto;
import com.naresh.Database.Dto.HotelReservationsInSpecificDateRange;
import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Entity.Reservations;
 

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	
	//  stored Procedure 
	
	
	@Procedure(procedureName = "update_rooms_price")
	
     public void  updateRoomPricesUsingProcedure(@Param("hote_name")String hotelName,@Param("price_per") int pricePer);
	   
	
   @Query(value="BEGIN  get_total_rooms_costs(:hote_name,:total_hotel_cost); END;",nativeQuery = true)
	 	
    public 	String getHotelRoomsCosts(@Param("hote_name")String hotelName, @Param("total_hotel_cost") AtomicReference<BigDecimal>  totalHotelCost);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
		
			
  
		// 2. Retrieve All Reservations for a Specific hotel
		
 
		
		@Query(value="select res.* from reservation res left join room r on res.room_id=r.room_id left join hotel h  on h.hotel_Id=r.hotel_Id  where h.hotel_name=:hotel_name",nativeQuery = true)
		
		public 	List<Object[]> getAllreservationsUnderSpecificHotel(@Param("hotel_name")String hotelName);
		
	// 5. Retrieve Hotels with the Total Number of Reservations
			
     @Query(value="select h.hotel_name as hotelName,count(r.room_id) as noOfRooms ,count (res.reservation_Id )as noOfReservations from hotel h"
		+ "  left join room r on h.hotel_id=r.hotel_id "
		+ "  left join reservation res on r.room_id=res.room_id  group by hotel_name",nativeQuery = true)	
			
   public 	List<AllHotelsNoOfRoomsReservationsDto> getAllHotelsRoomsAndReservations();
		
		
	// 7. Retrieve Reservations Made in a Specific Date Range for a Specific Hotel
     
     
     @Query(value="select h.hotel_name as hotelName ,res.reservation_Id as ReservationId from hotel h"
     		+ " inner join room r on h.hotel_id=r.hotel_id "
     		+ " inner join reservation res on r.room_id=res.room_id "
     		+ " where h.hotel_name=:hotel_name and res.check_in_date between :check_In_From and :check_In_To",nativeQuery = true)
		
     public List<Object[]> gettingReservationsinRangeDateforHotel(@Param("hotel_name") String hotelName,@Param("check_In_From")LocalDate checkInFrom,@Param("check_In_To") LocalDate checkInTo);

}
