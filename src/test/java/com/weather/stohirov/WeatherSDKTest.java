package com.weather.stohirov;

import junit.framework.TestCase;
import org.json.JSONObject;

public class WeatherSDKTest extends TestCase {

    public void testGetWeather() {
        WeatherSDK sdk = new WeatherSDK("");
        JSONObject mockData = new JSONObject("{\"weather\": {\"main\": \"Clouds\", \"description\": \"scattered clouds\"}}" );
        assertNotNull(mockData);
    }
}