package com.example.car_pricing.service;

import com.example.car_pricing.model.Car;
import com.example.car_pricing.model.CarPriceResult;
import com.example.car_pricing.region.CountryRegionMapper;
import com.example.car_pricing.region.Region;
import com.example.car_pricing.strategy.R1TaxStrategy;
import com.example.car_pricing.strategy.R2TaxStrategy;
import com.example.car_pricing.strategy.R3TaxStrategy;
import com.example.car_pricing.strategy.R4TaxStrategy;
import com.example.car_pricing.strategy.TaxStrategy;

import org.springframework.stereotype.Service;

@Service
public class CarPricingService {
	// Maps countries to their corresponding regions
	private final CountryRegionMapper mapper =
            new CountryRegionMapper();
	
	// Selects the tax strategy based on the region
    public TaxStrategy getTaxStrategy(Region region) {

        switch (region) {
            case R1:
                return new R1TaxStrategy();

            case R2:
                return new R2TaxStrategy();

            case R3:
                return new R3TaxStrategy();

            case R4:
                return new R4TaxStrategy();

            default:
                throw new IllegalArgumentException(
                    "Invalid region"
                );
        }
    }
    // Calculates tax and final car price
    public CarPriceResult calculatePrice(Car car) {

        Region region = mapper.getRegion(car.getCountry());

        TaxStrategy strategy = getTaxStrategy(region);

        double basePrice = car.getBasePrice();
        double tax = strategy.calculateTax(basePrice);
        double finalPrice = basePrice + tax;

        return new CarPriceResult(
            car.getCountry(),
            region.name(),
            region.getContinentName(),
            basePrice,
            strategy.getTaxRate(),
            tax,
            finalPrice
        );
    }
}

