package data_access;

import entity.WeatherData;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class OpenWeatherData {
    private static final String API_KEY =
            System.getenv("OPENWEATHER_API_KEY");
    public static String[] weatherCall = {"https://api.openweathermap.org/data/2.5/weather?lat=",
            "&lon=", "&appid=", "&units=metric"};
    public static String[] geocodeCall = {"https://api.openweathermap.org/geo/1.0/zip?zip=",
            "&appid="};
    OkHttpClient client = new OkHttpClient();

    /**
     * Uses the Geocoding API to find a city's latitude and longitude, then calls
     * fetchWeather using its values.
     *
     * @param zip_countryCode the zip and country code, separated by a comma (e.g. 1234,CA)
     */
    public void fetchCoordinates(String zip_countryCode) {
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

                fetchWeather(lat, lon);

            } else if (geoResponse.code() == 404) {
                System.out.println("Invalid zip code or country code. Please try again!");
            } else {
                System.out.println("API Key failed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Uses the OpenWeatherAPI to find the weather conditions of the city which holds
     * the latitude and longitude values from fetchCoordinates and turns the reply into
     * a WeatherData entity.
     *
     * @param lat latitude of city
     * @param lon longitude of city
     */
    private void fetchWeather(double lat, double lon) {
        Request weatherRequest = new Request.Builder()
                .url(weatherCall[0] + lat + weatherCall[1] + lon + weatherCall[2] +
                        API_KEY + weatherCall[3])
                .build();
        try (Response weatherResponse = client.newCall(weatherRequest).execute()) {
            if (weatherResponse.isSuccessful()) {
                assert weatherResponse.body() != null;

                String body = weatherResponse.body().string();
                JSONObject city = new JSONObject(body);

                JSONArray weather = city.getJSONArray("weather");
                JSONObject condition = weather.getJSONObject(0);
                String cityCondition = condition.getString("main");

                JSONObject temperature = city.getJSONObject("main");
                double cityTemperature = temperature.getDouble("temp");
                //WeatherData weatherData = new WeatherData(cityTemperature, cityCondition);


            } else if (weatherResponse.code() == 404) {
                System.out.println("Invalid zip code or country code. Please try again!");
            } else {
                System.out.println("API Key failed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OpenWeatherData weather = new OpenWeatherData();
        weather.fetchCoordinates("M1R3W3,CA");
    } //this is just for me to quick test
}
