package com.burakkoc.restaurantbooking.business.abstracts;

import java.util.List;

import com.burakkoc.restaurantbooking.entities.BookingHistory;
import com.burakkoc.restaurantbooking.utils.results.DataResult;
import com.burakkoc.restaurantbooking.utils.results.Result;

public interface BookingHistoryService {

	DataResult<BookingHistory> getById(int id);
	
    
	DataResult<List<BookingHistory>> getAll();
    
	Result add(BookingHistory bookingHistory);
    
	DataResult<List<BookingHistory>> getByUserId(int userId); // New method
    
    
    
}
