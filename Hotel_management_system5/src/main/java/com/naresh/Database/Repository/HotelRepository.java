package com.naresh.Database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naresh.Database.Entity.Hotel;
import com.naresh.Database.Entity.Reservations;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
