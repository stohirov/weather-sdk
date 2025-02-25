# Weather SDK for Java

## Overview
Weather SDK for Java is a lightweight and efficient library for fetching real-time weather data from the OpenWeather API. It includes built-in caching to optimize performance and reduce redundant API calls.

### Python Project
[Python SDK](https://github.com/stohirov/weather-sdk-python)

## Prerequisites
Ensure that you have **Java 21** installed on your system before using the SDK.

### Installing Java 21
#### Windows
1. Download the Java 21 installer from [Oracle JDK](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) or [Adoptium](https://adoptium.net/).
2. Run the installer and follow the setup instructions.
3. Verify the installation by running:
   ```sh
   java -version
   ```

#### macOS
1. Install Java 21 using Homebrew:
   ```sh
   brew install openjdk@21
   ```
2. Verify the installation:
   ```sh
   java -version
   ```

#### Linux (Ubuntu/Debian)
1. Install Java 21 using APT:
   ```sh
   sudo apt update
   sudo apt install openjdk-21-jdk
   ```
2. Verify the installation:
   ```sh
   java -version
   ```

## Installation

If you're using **Maven**, add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.weather.stohirov</groupId>
    <artifactId>weather-sdk</artifactId>
    <version>0.0.5</version>
</dependency>
```

If you're using **Gradle**, add this to your `build.gradle`:

```gradle
dependencies {
    implementation 'com.weather.stohirov:weather-sdk:1.0.0'
}
```

> **Note:** Ensure that the package is published to a public Maven repository (like Maven Central or JitPack). If using JitPack, you may need to add JitPack to your repositories.

## Usage
Test it inside the `Main` class:

```java
import com.weather.stohirov.WeatherSDK;
import com.weather.stohirov.WeatherException;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        WeatherSDK weatherSDK = new WeatherSDK("YOUR_API_KEY");
        try {
            JSONObject weather = weatherSDK.getWeather("London");
            System.out.println(weather.toString(4));
        } catch (WeatherException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

## Features
✅ Fetches real-time weather data from OpenWeather API  
✅ Caches up to 10 cities for 10 minutes to optimize API usage  
✅ Handles API errors gracefully with custom exceptions  
✅ Easy integration with Java applications  

For more details, refer to the [OpenWeather API documentation](https://openweathermap.org/api).

