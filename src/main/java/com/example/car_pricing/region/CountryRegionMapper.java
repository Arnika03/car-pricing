package com.example.car_pricing.region;

public class CountryRegionMapper {

	// Identifies the region associated with the given country
	public Region getRegion(String country) {

		// Validates that the country name is not empty
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException(
                "Country cannot be empty"
            );
        }

        switch (country.trim().toLowerCase()) {

            case "usa":
            case "united states":
                return Region.R1;

            case "germany":
            case "france":
                return Region.R2;

            case "india":
            case "japan":
                return Region.R3;

            case "south africa":
            case "egypt":
                return Region.R4;

            default:
            	// Rejects country names not supported by the current mapping
                throw new IllegalArgumentException(
                    "Country not supported: " + country
                );
        }
    }
}

