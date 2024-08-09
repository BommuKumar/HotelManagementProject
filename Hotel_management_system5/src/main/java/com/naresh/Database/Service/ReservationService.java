package com.naresh.Database.Service;

import java.util.List;

import com.naresh.Database.Entity.Reservations;
import com.naresh.Database.Entity.Room;

public interface ReservationService {
	
       public String bookRoom(Reservations reservations,int roomId);	
       
       public List<Integer> getAvailableRooms();

}
