package com.burakkoc.restaurantbooking.wepAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.burakkoc.restaurantbooking.business.abstracts.FoodService;
import com.burakkoc.restaurantbooking.entities.Food;
import com.burakkoc.restaurantbooking.utils.results.DataResult;
import com.burakkoc.restaurantbooking.utils.results.Result;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodsController {

    private final FoodService foodService;

    @Autowired
    public FoodsController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/restaurant/{restaurantId}")
    public DataResult<List<Food>> getFoodsByRestaurantId(@PathVariable int restaurantId) {
        return foodService.getAllByRestaurantId(restaurantId);
    }

    @GetMapping("/{id}")
    public DataResult<Food> getById(@PathVariable int id) {
        return foodService.getById(id);
    }

    @PostMapping
    public Result createFood(@RequestBody Food food) {
        return foodService.add(food);
    }
}
