package com.weather.stohirov;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class WeatherFetcher {
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";
    private final String apiKey;

    public WeatherFetcher(String apiKey) {
        this.apiKey = apiKey;
    }

    public JSONObject fetchWeather(String city) throws WeatherException {
        try {
            String urlString = String.format(API_URL, city, apiKey);
            HttpURLConnection conn = (HttpURLConnection) new URI(urlString).toURL().openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                throw new WeatherException("Error fetching weather data: " + conn.getResponseMessage());
            }

            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            return new JSONObject(response.toString());
        } catch (IOException e) {
            throw new WeatherException("Failed to fetch weather data", e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}