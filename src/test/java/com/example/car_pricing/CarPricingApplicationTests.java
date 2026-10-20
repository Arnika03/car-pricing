
package com.example.car_pricing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.car_pricing.model.Car;
import com.example.car_pricing.region.CountryRegionMapper;
import com.example.car_pricing.strategy.R1TaxStrategy;

@SpringBootTest
class CarPricingApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void shouldCalculateTaxCorrectly() {
        R1TaxStrategy strategy = new R1TaxStrategy();

        double tax = strategy.calculateTax(100000);

        assertEquals(10000.0, tax, 0.001);
    }

    @Test
    void shouldRejectZeroPrice() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Car("India", 0)
        );
    }

    @Test
    void shouldRejectUnsupportedCountry() {
        CountryRegionMapper mapper = new CountryRegionMapper();

        assertThrows(
            IllegalArgumentException.class,
            () -> mapper.getRegion("China")
        );
    }
}
