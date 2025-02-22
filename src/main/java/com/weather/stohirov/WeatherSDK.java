package com.weather.stohirov;

import org.json.JSONObject;

public class WeatherSDK {
    private final String apiKey;
    private final WeatherCache cache;
    private final WeatherFetcher fetcher;

    public WeatherSDK(String apiKey) {
        this.apiKey = apiKey;
        this.cache = new WeatherCache(10, 600000);
        this.fetcher = new WeatherFetcher(apiKey);
    }

    public JSONObject getWeather(String city) throws WeatherException {
        if (city == null || city.isEmpty()) {
            throw new WeatherException("City name cannot be empty");
        }

        JSONObject cachedWeather = cache.get(city);
        if (cachedWeather != null) {
            return cachedWeather;
        }

        JSONObject weatherData = fetcher.fetchWeather(city);
        cache.put(city, weatherData);

        return weatherData;
    }
}