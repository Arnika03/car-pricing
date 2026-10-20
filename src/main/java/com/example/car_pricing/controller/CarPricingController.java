package com.example.car_pricing.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.car_pricing.model.Car;
import com.example.car_pricing.model.CarPriceResult;
import com.example.car_pricing.service.CarPricingService;

@RestController
//Defines the base URL for car-related APIs
@RequestMapping("/api/cars")
public class CarPricingController {

	private final CarPricingService pricingService;

	// Injects the pricing service through the constructor
	public CarPricingController(CarPricingService pricingService) {
		this.pricingService = pricingService;
	}

	// Accepts a POST request to calculate the car's final price
	@PostMapping("/calculate")
	public CarPriceResult calculatePrice(@RequestBody Car car) {

		// Delegates the calculation to the service layer
		return pricingService.calculatePrice(car);
	}
}
