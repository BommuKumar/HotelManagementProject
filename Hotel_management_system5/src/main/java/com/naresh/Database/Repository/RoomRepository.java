package com.naresh.Database.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.naresh.Database.Entity.Reservations;
import com.naresh.Database.Entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	
	@Query(value="select * from room where room_id=:roomId and availability='Available'",nativeQuery = true)
	
	   public Room isRoomAvailable(@Param("roomId") int roomId);
	
	 
	@Query(value="select * from room where availability='Available'",nativeQuery = true)
	
	   public List<Room> getAllAvailableRooms();
	
}
