package use_case.algorithm;

import entity.WeatherData;

/**
 * Data access interface for retrieving current weather data for outfit generation.
 */

public interface WeatherDataAccessInterface {
    /**
     * Retrieves the current weather data for the configured location.
     *
     * @return the current {@link WeatherData}, or {@code null} if weather data cannot be retrieved
     */
    WeatherData getCurrentWeather();
}
