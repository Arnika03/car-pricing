package com.example.car_pricing.strategy;

//Provides common tax calculation logic for all tax strategies
public abstract class BaseTaxStrategy 
implements TaxStrategy {

	    private final double taxRate;

	    public BaseTaxStrategy(double taxRate) {
	        this.taxRate = taxRate;
	    }

	    @Override
	    public double getTaxRate() {
	        return taxRate;
	    }

	    @Override
	    public double calculateTax(double basePrice) {
	    	// Calculates tax using the base price and percentage rate
	        return basePrice * taxRate / 100;
	    }
}
