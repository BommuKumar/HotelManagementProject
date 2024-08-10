package com.naresh.Database.Service;

import java.util.List;

import com.naresh.Database.Entity.Reservations;
import com.naresh.Database.Entity.Room;

public interface ReservationService {
	
       public String bookRoom(Reservations reservations,int roomId);	
       
       public List<Integer> getAvailableRooms();
       
       public String cancelReservations(int reservationId);
       
       public List<Room>  getallRoomsByHname(String hotelName);
       
       public List<Room>  getallAvailableRoomsByHname(String hotelName);
       
       public int getTotalCostofRooms(String hotelName);
       
       public List<Room> getRoomsBelowPrice(int price,String hotelName);
       
       public List<Room> getRoomspricesWith10PercentDiscountOnMrp(String hotelName);
       
       public List<Room> getroomsAscBySortingOfPrice(String hotelName);
       
       public List<Room> getroomsDscBySortingOfPrice(String hotelName);
       
       
       public Room getHighCostRoom(String hotelName);
       
       

}
