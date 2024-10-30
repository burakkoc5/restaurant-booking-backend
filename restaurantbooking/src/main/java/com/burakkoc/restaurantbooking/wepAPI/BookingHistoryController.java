package com.burakkoc.restaurantbooking.wepAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.burakkoc.restaurantbooking.business.abstracts.BookingHistoryService;
import com.burakkoc.restaurantbooking.entities.BookingHistory;
import com.burakkoc.restaurantbooking.utils.results.DataResult;
import com.burakkoc.restaurantbooking.utils.results.Result;

import java.util.List;

@RestController
@RequestMapping("/api/booking-history")
public class BookingHistoryController {

    private final BookingHistoryService bookingHistoryService;

    @Autowired
    public BookingHistoryController(BookingHistoryService bookingHistoryService) {
        this.bookingHistoryService = bookingHistoryService;
    }

    @GetMapping
    public DataResult<List<BookingHistory>> getAllBookingHistories() {
        return bookingHistoryService.getAll();
    }

    @GetMapping("/user/{userId}")
    public DataResult<List<BookingHistory>> getBookingHistoriesByUserId(@PathVariable int userId) {
        return bookingHistoryService.getByUserId(userId);
    }

    @PostMapping
    public Result createBookingHistory(@RequestBody BookingHistory bookingHistory) {
        return bookingHistoryService.add(bookingHistory);
    }

    @GetMapping("/{id}")
    public DataResult<BookingHistory> getBookingHistoryById(@PathVariable int id) {
        return bookingHistoryService.getById(id);
    }
}
