package com.burakkoc.restaurantbooking.wepAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.burakkoc.restaurantbooking.business.abstracts.BookingService;
import com.burakkoc.restaurantbooking.entities.Booking;
import com.burakkoc.restaurantbooking.utils.results.DataResult;
import com.burakkoc.restaurantbooking.utils.results.Result;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingsController {

    private final BookingService bookingService;

    @Autowired
    public BookingsController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public void createBooking(@RequestBody Booking booking) {
        bookingService.add(booking);
    }

    @GetMapping
    public DataResult<List<Booking>> getAllBookings() {
        return bookingService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Booking> getBookingById(@PathVariable int id) {
        return bookingService.getById(id);
    }

    @PutMapping("/{id}")
    public Result updateBooking(@PathVariable int id, @RequestBody Booking booking) {
    	return bookingService.update(id, booking);
    }

    @DeleteMapping("/{id}")
    public Result deleteBooking(@PathVariable int id) {
        return bookingService.delete(id);
    }
    
    @GetMapping("/restaurant/{restaurantId}")
    public DataResult<List<Booking>> getAllBookingsByRestaurantId(@PathVariable int restaurantId) {
        return bookingService.getAllBookingsByRestaurantId(restaurantId);
    }

    @GetMapping("/user/{userId}")
    public DataResult<List<Booking>> getAllBookingsByUserId(@PathVariable int userId) {
        return bookingService.getAllBookingsByUserId(userId);
    }
}
