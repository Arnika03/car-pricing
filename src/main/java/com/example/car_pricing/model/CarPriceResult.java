package com.example.car_pricing.model;

public class CarPriceResult {
	private String country;
    private String region;
    private String continent;
    private double basePrice;
    private double taxRate;
    private double taxAmount;
    private double finalPrice;

    // Initializes the result with all car pricing and tax details
    public CarPriceResult(String country, String region,
            String continent, double basePrice,
            double taxRate, double taxAmount,
            double finalPrice) {

        this.country = country;
        this.region = region;
        this.continent = continent;
        this.basePrice = basePrice;
        this.taxRate = taxRate;
        this.taxAmount = taxAmount;
        this.finalPrice = finalPrice;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getContinent() {
        return continent;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

}
