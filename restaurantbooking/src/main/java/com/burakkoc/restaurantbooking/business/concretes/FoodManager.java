package com.burakkoc.restaurantbooking.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakkoc.restaurantbooking.business.abstracts.FoodService;
import com.burakkoc.restaurantbooking.dataAccess.abstracts.FoodRepository;
import com.burakkoc.restaurantbooking.entities.Food;
import com.burakkoc.restaurantbooking.utils.results.DataResult;
import com.burakkoc.restaurantbooking.utils.results.Result;
import com.burakkoc.restaurantbooking.utils.results.SuccessDataResult;
import com.burakkoc.restaurantbooking.utils.results.ErrorDataResult;
import com.burakkoc.restaurantbooking.utils.results.SuccessResult;

@Service
public class FoodManager implements FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodManager(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public DataResult<Food> getById(int id) {
        Optional<Food> food = foodRepository.findById(id);
        if (food.isPresent()) {
            return new SuccessDataResult<Food>(food.get(), "Food item fetched successfully.");
        } else {
            return new ErrorDataResult<Food>(null,"Food item not found with id: " + id);
        }
    }

    @Override
    public DataResult<List<Food>> getAll() {
        List<Food> foods = foodRepository.findAll();
        return new SuccessDataResult<List<Food>>(foods, "All food items fetched successfully.");
    }

    @Override
    public Result add(Food food) {
        foodRepository.save(food);
        return new SuccessResult("Food item added successfully.");
    }
    
    @Override
    public DataResult<List<Food>> getAllByRestaurantId(int restaurantId) {
        List<Food> foods = foodRepository.findByRestaurantId(restaurantId);
        return new SuccessDataResult<List<Food>>(foods, "All food items for restaurant fetched successfully.");
    }
}
