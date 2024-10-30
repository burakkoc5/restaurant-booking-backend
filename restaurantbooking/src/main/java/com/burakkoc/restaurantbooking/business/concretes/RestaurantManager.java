package com.burakkoc.restaurantbooking.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakkoc.restaurantbooking.business.abstracts.RestaurantService;
import com.burakkoc.restaurantbooking.dataAccess.abstracts.RestaurantRepository;
import com.burakkoc.restaurantbooking.entities.Restaurant;
import com.burakkoc.restaurantbooking.utils.results.DataResult;
import com.burakkoc.restaurantbooking.utils.results.Result;
import com.burakkoc.restaurantbooking.utils.results.SuccessDataResult;
import com.burakkoc.restaurantbooking.utils.results.ErrorDataResult;
import com.burakkoc.restaurantbooking.utils.results.SuccessResult;


@Service
public class RestaurantManager implements RestaurantService {
	
	private final RestaurantRepository restaurantRepository;
	
	@Autowired
	public RestaurantManager(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public DataResult<Restaurant> getById(int id) {
		Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (restaurant.isPresent()) {
            return new SuccessDataResult<Restaurant>(restaurant.get(), "Restaurant fetched successfully.");
        } else {
            return new ErrorDataResult<Restaurant>(null,"Restaurant not found with id: " + id);
        }
	}

	@Override
	public DataResult<List<Restaurant>> getAll() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		return new SuccessDataResult<List<Restaurant>>(restaurants, "All restaurants fetched successfully.");
	}

	@Override
	public Result add(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
		return new SuccessResult("Restaurant added successfully.");
	}
}