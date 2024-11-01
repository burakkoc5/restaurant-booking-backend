package com.burakkoc.restaurantbooking.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakkoc.restaurantbooking.business.abstracts.BookingService;
import com.burakkoc.restaurantbooking.dataAccess.abstracts.BookingRepository;
import com.burakkoc.restaurantbooking.entities.Booking;
import com.burakkoc.restaurantbooking.utils.results.ErrorDataResult;
import com.burakkoc.restaurantbooking.utils.results.Result;
import com.burakkoc.restaurantbooking.utils.results.SuccessDataResult;
import com.burakkoc.restaurantbooking.utils.results.SuccessResult;
import com.burakkoc.restaurantbooking.utils.results.DataResult;


@Service
public class BookingManager implements BookingService {
    
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingManager(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public DataResult<Booking> getById(int id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking == null) {
            return new ErrorDataResult<Booking>(null,"Booking not found with id: " + id);
        }
        return new SuccessDataResult<Booking>(booking, "Booking fetched successfully.");
    }

    @Override
    public DataResult<List<Booking>> getAll() {
        List<Booking> bookings = bookingRepository.findAll();
        return new SuccessDataResult<List<Booking>>(bookings, "All bookings fetched successfully.");
    }

    @Override
    public Result add(Booking booking) {
        bookingRepository.save(booking);
        return new SuccessResult("Booking added successfully.");
    }

    @Override
    public Result update(int id, Booking booking) {
        // Check if booking exists
        if (bookingRepository.existsById(id)) {
            booking.setId(id); // Set the existing ID to ensure it updates the correct record
            bookingRepository.save(booking);
            return new SuccessResult("Booking updated successfully.");
        } else {
            return new ErrorDataResult<>("Booking not found with id: " + id);
        }
    }

    @Override
    public Result delete(int id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return new SuccessResult("Booking deleted successfully.");
        } else {
            return new ErrorDataResult<>("Booking not found with id: " + id);
        }
    }
    
    @Override
    public DataResult<List<Booking>> getAllBookingsByRestaurantId(int restaurantId) {
        List<Booking> bookings = bookingRepository.findAllByRestaurantId(restaurantId);
        return new SuccessDataResult<List<Booking>>(bookings, "All bookings for restaurant fetched successfully.");
    }

    @Override
    public DataResult<List<Booking>> getAllBookingsByUserId(int userId) {
        List<Booking> bookings = bookingRepository.findAllByUserId(userId);
        return new SuccessDataResult<List<Booking>>(bookings, "All bookings for user fetched successfully.");
    }

}
