package com.burakkoc.restaurantbooking.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.burakkoc.restaurantbooking.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // You can add custom query methods here if needed
	
	Optional<User> findByEmail(String email);
}
