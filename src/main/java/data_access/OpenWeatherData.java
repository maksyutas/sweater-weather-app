package data_access;

import entity.WeatherData;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class OpenWeatherData {
    private static final String API_KEY =
            System.getenv("OPENWEATHER_API_KEY");
    String[] weatherCall = {"https://api.openweathermap.org/data/2.5/weather?lat=",
            "&lon=", "&appid="};
    String[] geocodeCall = {"https://api.openweathermap.org/geo/1.0/zip?zip=", "&appid="};

    /**
     * Returns the city's current weather as a WeatherData entity.
     *
     * @param zip_countryCode the zip and country code, separated by a comma (e.g. 1234,CA)
     * @return WeatherData entity which holds the city's weather data
     */
    public WeatherData fetchWeather(String zip_countryCode) {
        OkHttpClient client = new OkHttpClient();

         Request geoRequest = new Request.Builder()
         .url(geocodeCall[0] + zip_countryCode + geocodeCall[1] + API_KEY)
         .build();
        /**
         try (Response response = client.newCall(geoRequest).execute()) {
         if (response.isSuccessful()) {
         String body = response.body().string();  // the response as text
         System.out.println(body);
         } else {
         System.out.println("Request failed with code " + response.code());
         }
         } catch (IOException e) {
         // A network problem (no connection, timeout, ...) — handle it gracefully.
         e.printStackTrace();
         }
         */
    }

}
