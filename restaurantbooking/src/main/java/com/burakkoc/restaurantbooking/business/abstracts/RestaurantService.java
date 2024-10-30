package com.burakkoc.restaurantbooking.business.abstracts;

import java.util.List;

import com.burakkoc.restaurantbooking.entities.Restaurant;
import com.burakkoc.restaurantbooking.utils.results.DataResult;
import com.burakkoc.restaurantbooking.utils.results.Result;

public interface RestaurantService {
	
	DataResult<Restaurant> getById(int id);
	
	DataResult<List<Restaurant>> getAll();
	
	Result add(Restaurant restaurant);
	
	

}
