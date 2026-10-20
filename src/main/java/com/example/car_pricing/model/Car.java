package com.example.car_pricing.model;

public class Car {
	private String country;
    private double basePrice;

    // Initializes the car's country and base price
    public Car(String country, double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException(
                "Price must be greater than zero"
            );
        }

        this.country = country;
        this.basePrice = basePrice;
    }

    // Returns the country where the car price is being calculated
    public String getCountry() {
        return country;
    }

    public double getBasePrice() {
        return basePrice;
    }

}
