package com.naresh.Database.Repository;

import java.util.List;

import org.hibernate.annotations.QueryCacheLayout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.naresh.Database.Entity.Reservations;
import com.naresh.Database.Entity.Room;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Integer>{
 
	 
}
