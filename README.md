# Regional Car Pricing and Tax Calculation System

A Java Spring Boot REST API that calculates car prices based on the country, regional tax strategy, and base price.

## Overview

The Regional Car Pricing and Tax Calculation System is a backend application designed to calculate the applicable tax and final price of a car based on its country.

The application uses Object-Oriented Programming (OOP) principles and the Strategy Design Pattern to organize region-specific tax calculations.

## Features

- Calculate car tax and final price based on the country.
- Support four regions: North America, Europe, Asia, and Africa.
- Apply region-specific tax strategies.
- Validate car prices to prevent zero or negative values.
- Handle invalid input and unsupported countries with HTTP 400 error responses.
- Expose REST APIs using Spring Boot.
- Include automated tests for tax calculation and input validation.

## Technologies Used

- Java 21
- Spring Boot
- Spring Web MVC
- Maven
- REST API
- JUnit
- Postman

## Project Structure

```text
src/
├── main/
│   ├── java/com/example/car_pricing/
│   │   ├── controller/
│   │   ├── exception/
│   │   ├── model/
│   │   ├── region/
│   │   ├── service/
│   │   └── strategy/
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/example/car_pricing/
        └── CarPricingApplicationTests.java
```

## Region and Tax Configuration

| Region Code | Region | Example Tax Rate |
|---|---|---:|
| R1 | North America | 10% |
| R2 | Europe | 15% |
| R3 | Asia | 12% |
| R4 | Africa | 8% |

**Note:** These are illustrative tax rates configured for demonstration and testing. They do not represent verified real-world country tax rates.

### Currently Supported Countries

- **North America:** USA, United States
- **Europe:** Germany, France
- **Asia:** India, Japan
- **Africa:** South Africa, Egypt

## REST API

### Calculate Car Price

**Method:** `POST`

**Endpoint:** `/api/cars/calculate`

**Local URL:**

```text
http://localhost:8080/api/cars/calculate
```

### Request Body

```json
{
  "country": "India",
  "basePrice": 1000000
}
```

### Example Response

```json
{
  "country": "India",
  "region": "R3",
  "continent": "Asia",
  "basePrice": 1000000.0,
  "taxRate": 12.0,
  "taxAmount": 120000.0,
  "finalPrice": 1120000.0
}
```

### Error Response

For an unsupported country:

```json
{
  "error": "Country not supported: China"
}
```

The API returns HTTP `400 Bad Request` for unsupported countries and invalid car prices.

## How to Run the Project

### Prerequisites

- Java JDK 21
- Git
- Postman for API testing

### Steps

**1. Clone the repository**

```bash
git clone https://github.com/Arnika03/car-pricing.git
```

**2. Navigate to the project directory**

```bash
cd car-pricing
```

**3. Run the application on Windows**

```powershell
.\mvnw.cmd spring-boot:run
```

**4. Test the API using Postman**

Send a `POST` request to:

```text
http://localhost:8080/api/cars/calculate
```

Select **Body → raw → JSON**, enter the request body provided above, and click **Send**.

## Testing

The project includes tests for:

- Spring application context loading
- Tax calculation
- Rejection of zero car prices
- Rejection of unsupported countries

Run the tests on Windows using:

```powershell
.\mvnw.cmd test
```

## Design Principles

- **Encapsulation:** Keeps car and pricing result data within model classes.
- **Inheritance:** Shares common tax calculation logic through a base strategy class.
- **Polymorphism:** Uses a common tax strategy interface for regional implementations.
- **Strategy Design Pattern:** Separates tax calculation logic into region-specific strategy classes.
- **Separation of Concerns:** Organizes controllers, services, models, regional mapping, and exception handling into separate packages.

## Future Enhancements

- Add support for more countries and configurable tax rates.
- Integrate a database to store country and tax configuration.
- Add request validation and more comprehensive automated tests.
- Develop a React frontend.
- Add API documentation using OpenAPI/Swagger.

## Author

**Arnika Pandey**

- GitHub: [Arnika03](https://github.com/Arnika03)
- LinkedIn: [Arnika Pandey](https://www.linkedin.com/in/arnika-pandey-609857302/)
