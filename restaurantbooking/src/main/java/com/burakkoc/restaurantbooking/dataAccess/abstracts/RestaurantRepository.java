package com.burakkoc.restaurantbooking.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.burakkoc.restaurantbooking.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	
}
