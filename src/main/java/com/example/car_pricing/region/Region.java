package com.example.car_pricing.region;

//Defines the four regions supported by the application
public enum Region {
	R1("North America"),
    R2("Europe"),
    R3("Asia"),
    R4("Africa");

	// Stores the display name of the region
    private final String continentName;

    // Initializes the region with its display name
    Region(String continentName) {
        this.continentName = continentName;
    }

    // Returns the display name of the region
    public String getContinentName() {
        return continentName;
    }
}
