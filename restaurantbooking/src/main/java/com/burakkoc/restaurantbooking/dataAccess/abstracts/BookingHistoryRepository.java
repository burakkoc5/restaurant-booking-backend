package com.burakkoc.restaurantbooking.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.burakkoc.restaurantbooking.entities.BookingHistory;

import java.util.List;

@Repository
public interface BookingHistoryRepository extends JpaRepository<BookingHistory, Integer> {
    
    // Method to find booking history by user ID
    List<BookingHistory> findByUserId(int userId);
}
