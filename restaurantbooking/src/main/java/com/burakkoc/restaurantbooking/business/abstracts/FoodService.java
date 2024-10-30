package com.burakkoc.restaurantbooking.business.abstracts;

import java.util.List;

import com.burakkoc.restaurantbooking.entities.Food;
import com.burakkoc.restaurantbooking.utils.results.DataResult;
import com.burakkoc.restaurantbooking.utils.results.Result;

public interface FoodService {
    
	DataResult<Food> getById(int id);
    
    DataResult<List<Food>> getAll();
    
    Result add(Food food);
    
    DataResult<List<Food>> getAllByRestaurantId(int restaurantId);
}
