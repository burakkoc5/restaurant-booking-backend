package com.burakkoc.restaurantbooking.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.burakkoc.restaurantbooking.entities.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
	
	List<Food> findByRestaurantId(int restaurantId);
}
