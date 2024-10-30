package com.burakkoc.restaurantbooking.wepAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.burakkoc.restaurantbooking.business.abstracts.RestaurantService;
import com.burakkoc.restaurantbooking.entities.Restaurant;
import com.burakkoc.restaurantbooking.utils.results.DataResult;
import com.burakkoc.restaurantbooking.utils.results.Result;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantsController {
	
	private RestaurantService restaurantService;
	
	@Autowired
	public RestaurantsController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Restaurant>> getAll(){
		return restaurantService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Restaurant> getById(@RequestParam int id){
		return restaurantService.getById(id);
	}
	
	@PostMapping
	public Result createRestaurant(@RequestBody Restaurant restaurant) {
	   return restaurantService.add(restaurant);
	}

}
