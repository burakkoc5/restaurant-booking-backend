package com.burakkoc.restaurantbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class RestaurantBookingApplication {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RestaurantBookingApplication.class, args);
	}
	
	@PostConstruct
    public void checkDatabaseConnection() {
        try {
            // Execute a simple query to check the connection
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            if (result != null && result == 1) {
                System.out.println("Database connection is successful!");
            } else {
                System.out.println("Failed to verify database connection.");
            }
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

}
