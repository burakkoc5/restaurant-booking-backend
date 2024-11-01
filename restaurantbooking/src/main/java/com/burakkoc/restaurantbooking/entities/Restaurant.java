package com.burakkoc.restaurantbooking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="restaurants")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private String name;
	
    private String address;
    
    private double latitude;
    
    private double longitude;
    
    private String openTime; // or use java.time.LocalTime for better time handling
    
    private String closeTime; // or use java.time.LocalTime for better time handling
    
    private String imageUrl;

}