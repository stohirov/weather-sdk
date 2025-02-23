package com.weather.stohirov;

public class Main {
    public static void main(String[] args) {
        WeatherSDK sdk = new WeatherSDK("YOUR_API_KEY");
        try {
            System.out.println(sdk.getWeather("CITY").toString(4));
        } catch (WeatherException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
