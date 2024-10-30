package com.burakkoc.restaurantbooking.business.abstracts;

import java.util.List;

import com.burakkoc.restaurantbooking.entities.Booking;
import com.burakkoc.restaurantbooking.utils.results.DataResult;
import com.burakkoc.restaurantbooking.utils.results.Result;

public interface BookingService {
    
	DataResult<Booking> getById(int id);
    
	DataResult<List<Booking>> getAll();
    
    Result add(Booking booking);
    
    Result update(int id, Booking booking);
    
    Result delete(int id);
    
    DataResult<List<Booking>> getAllBookingsByRestaurantId(int restaurantId);
    
    DataResult<List<Booking>> getAllBookingsByUserId(int userId);
}
