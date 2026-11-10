package data_access;

import entity.WeatherData;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

public class OpenWeatherData {
    private static final String API_KEY =
            System.getenv("OPENWEATHER_API_KEY");
    public static String[] weatherCall = {"https://api.openweathermap.org/data/2.5/weather?lat=",
            "&lon=", "&appid="};
    public static String[] geocodeCall = {"https://api.openweathermap.org/geo/1.0/zip?zip=",
            "&appid="};

    /**
     * Returns the city's current weather as a WeatherData entity.
     *
     * @param zip_countryCode the zip and country code, separated by a comma (e.g. 1234,CA)
     * @return WeatherData entity which holds the city's weather data
     */
    public void fetchWeather(String zip_countryCode) {
        //System.out.println("API key loaded: " + (API_KEY != null && !API_KEY.isBlank()));
        OkHttpClient client = new OkHttpClient();
        Request geoRequest = new Request.Builder()
         .url(geocodeCall[0] + zip_countryCode + geocodeCall[1] + API_KEY)
         .build();
         try (Response geoResponse = client.newCall(geoRequest).execute()) {
         if (geoResponse.isSuccessful()) {
             assert geoResponse.body() != null;
             String body = geoResponse.body().string();
             JSONObject city = new JSONObject(body);
             double lat = city.getDouble("lat");
             double lon = city.getDouble("lon");

             } else if (geoResponse.code() == 404) {
             System.out.println("Invalid zip code or country code. Please try again!");
         }
         else {
             System.out.println("API Key failed.");
         }
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    public static void main(String[] args) {
        OpenWeatherData weather = new OpenWeatherData();
        weather.fetchWeather("M1R3W3,CA");
    }
}
