package use_case.algorithm;

import entity.WeatherData;

public interface AlgorithmDataAccessInterface {

    public WeatherData getWeather(String zipCode, String countryCode);

    }
