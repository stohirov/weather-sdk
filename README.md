# Weather SDK for Java

## Overview
A simple Java SDK for fetching weather data from OpenWeather API with caching support.

## Installation
Include the SDK in your Java project by adding the `.jar` file or using a package manager (if available).

## Usage
```java
WeatherSDK weatherSDK = new WeatherSDK("YOUR_API_KEY");
try {
    JSONObject weather = weatherSDK.getWeather("London");
    System.out.println(weather.toString(2));
} catch (WeatherException e) {
    System.err.println("Error: " + e.getMessage());
}
```

## Features
- Fetches weather data using OpenWeather API
- Caches up to 10 cities for 10 minutes
- Exception handling for errors