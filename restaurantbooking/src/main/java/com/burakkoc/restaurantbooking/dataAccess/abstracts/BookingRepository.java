package com.burakkoc.restaurantbooking.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.burakkoc.restaurantbooking.entities.Booking;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    
    // Custom method to find all bookings for a specific user (if needed)
    List<Booking> findByUserId(int userId);
    List<Booking> findAllByRestaurantId(int restaurantId);
    List<Booking> findAllByUserId(int userId);
    
}
