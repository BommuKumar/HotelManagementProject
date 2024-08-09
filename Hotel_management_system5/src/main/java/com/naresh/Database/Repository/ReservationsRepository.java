package com.naresh.Database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.naresh.Database.Entity.Reservations;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Integer>{
	
	
	 
}
