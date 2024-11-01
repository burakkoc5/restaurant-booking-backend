package com.burakkoc.restaurantbooking.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakkoc.restaurantbooking.business.abstracts.BookingHistoryService;
import com.burakkoc.restaurantbooking.dataAccess.abstracts.BookingHistoryRepository;
import com.burakkoc.restaurantbooking.entities.BookingHistory;
import com.burakkoc.restaurantbooking.utils.results.DataResult;
import com.burakkoc.restaurantbooking.utils.results.ErrorDataResult;
import com.burakkoc.restaurantbooking.utils.results.Result;
import com.burakkoc.restaurantbooking.utils.results.SuccessDataResult;
import com.burakkoc.restaurantbooking.utils.results.SuccessResult;

@Service
public class BookingHistoryManager implements BookingHistoryService {

    private final BookingHistoryRepository bookingHistoryRepository;

    @Autowired
    public BookingHistoryManager(BookingHistoryRepository bookingHistoryRepository) {
        this.bookingHistoryRepository = bookingHistoryRepository;
    }

    @Override
    public DataResult<BookingHistory> getById(int id) {
        BookingHistory bookingHistory = bookingHistoryRepository.findById(id).orElse(null);
        if (bookingHistory == null) {
            return new ErrorDataResult<BookingHistory>(null,"Booking history not found."); // Not found durumunu işleyin
        }
        return new SuccessDataResult<BookingHistory>(bookingHistory, "Booking history fetched successfully.");
    }

    @Override
    public DataResult<List<BookingHistory>> getAll() {
        List<BookingHistory> bookingHistories = bookingHistoryRepository.findAll();
        return new SuccessDataResult<List<BookingHistory>>(bookingHistories, "All booking histories fetched successfully.");
    }

    @Override
    public Result add(BookingHistory bookingHistory) {
        bookingHistoryRepository.save(bookingHistory);
        return new SuccessResult("Booking history added successfully."); // Başarılı ekleme durumu
    }
    @Override
    public DataResult<List<BookingHistory>> getByUserId(int userId) {
        return new SuccessDataResult<List<BookingHistory>>(bookingHistoryRepository.findByUserId(userId),"");
    }
}
