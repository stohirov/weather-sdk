package com.weather.stohirov;

import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

class WeatherCache {
    private final Map<String, CachedWeather> cache;
    private final int maxSize;
    private final long expirationTime;

    public WeatherCache(int maxSize, long expirationTime) {
        this.maxSize = maxSize;
        this.expirationTime = expirationTime;
        this.cache = new LinkedHashMap<>(maxSize, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, CachedWeather> eldest) {
                return size() > maxSize;
            }
        };
    }

    public void put(String city, JSONObject data) {
        cache.put(city, new CachedWeather(data));
    }

    public JSONObject get(String city) {
        CachedWeather entry = cache.get(city);
        if (entry != null && System.currentTimeMillis() - entry.timestamp < expirationTime) {
            return entry.data;
        }
        cache.remove(city);
        return null;
    }

    private static class CachedWeather {
        JSONObject data;
        long timestamp;

        CachedWeather(JSONObject data) {
            this.data = data;
            this.timestamp = System.currentTimeMillis();
        }
    }
}