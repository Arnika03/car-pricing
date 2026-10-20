package com.example.car_pricing.strategy;

//Defines the contract that all tax strategies must implement
public interface TaxStrategy {
	double calculateTax(double basePrice);

    double getTaxRate();

}
