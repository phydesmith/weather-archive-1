package io.javasmithy.data;

import java.net.URL;
import java.net.MalformedURLException;

import java.io.InputStream;
import java.io.IOException;

public class WeatherService {
    private URL currentObvsStation;

    public WeatherService(String stationId) throws MalformedURLException {
        this.currentObvsStation = new URL("https://w1.weather.gov/xml/current_obs/"+stationId+".rss");
    }

    public InputStream getCurrentObservation() throws IOException{
        return this.currentObvsStation.openStream();
    }
}