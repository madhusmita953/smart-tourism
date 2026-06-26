# Smart Tourism Service

A Spring Boot microservice for managing tourist places and temperature data collection from smart tourism applications.

## Prerequisites

- Java 21
- Maven 3.8+
- Spring Boot 3.3.0

## Technology Stack

- **Java 21**
- **Spring Boot 3.3.0**
- **Spring Web**
- **Jackson XML & JSON**
- **Lombok**
- **Maven**

## Project Structure

```
src/main/
├── java/com/smarttourism/
│   ├── SmartTourismApplication.java
│   ├── config/
│   │   ├── RestTemplateConfig.java
│   │   └── JacksonConfig.java
│   ├── controller/
│   │   ├── TouristPlaceController.java
│   │   ├── TemperatureController.java
│   │   └── EndpointRegistrationController.java
│   ├── service/
│   │   ├── TouristPlaceService.java
│   │   ├── TemperatureService.java
│   │   └── ExternalApiService.java
│   ├── repository/
│   │   ├── TouristPlaceRepository.java
│   │   └── TemperatureRepository.java
│   └── model/
│       ├── TouristPlace.java
│       ├── Temperature.java
│       ├── TemperatureResponse.java
│       └── ApiEndpointRequest.java
└── resources/
    └── application.yml
```

## API Endpoints

### Tourist Places Management

- **GET** `/v1/tourist-places` - Get all tourist places
- **POST** `/v1/register-place` - Register a new tourist place
- **GET** `/v1/tourist-places/{city}` - Get tourist places by city
- **POST** `/v1/select-tour/{id}` - Select a tour by ID

### Temperature Management

- **POST** `/v1/my-tourist-places/{city}` - Capture temperature for a city
- **GET** `/v1/temperatures/{city}` - Get temperatures for a city
- **GET** `/v1/receive-all-temperatures` - Get all captured temperatures

### API Endpoint Registration

- **POST** `/v1/api-endpoint` - Register external API endpoint with Base64 encoded hostname

## Running the Application

### 1. Build the Project

```bash
mvn clean install
```

### 2. Run the Application

```bash
mvn spring-boot:run
```

The service will start on `http://localhost:8081`

## Example API Usage

### Register a Tourist Place

```bash
curl -X POST http://localhost:8081/v1/register-place \
  -H "Content-Type: application/json" \
  -d '{
    "city": "Paris",
    "placeName": "Eiffel Tower",
    "description": "Iconic iron lattice tower",
    "rating": 4.8
  }'
```

### Capture Temperature

```bash
curl -X POST http://localhost:8081/v1/my-tourist-places/Paris \
  -H "Content-Type: application/json" \
  -d '{
    "temperature": 22.5,
    "unit": "Celsius"
  }'
```

### Get All Tourist Places

```bash
curl http://localhost:8081/v1/tourist-places
```

### Get All Temperatures

```bash
curl http://localhost:8081/v1/receive-all-temperatures
```

### Register API Endpoint

```bash
curl -X POST http://localhost:8081/v1/api-endpoint \
  -H "Content-Type: application/json" \
  -d '{
    "endpoint": "/v1/receive-all-temperatures",
    "hostname": "localhost"
  }'
```

## Features

✅ Tourist place registration and management
✅ Temperature data collection and storage
✅ XML to JSON conversion support
✅ Base64 encoded hostname support
✅ RESTful API endpoints
✅ Thread-safe in-memory data storage
✅ Comprehensive logging with SLF4J
✅ Spring Boot best practices

## License

MIT
