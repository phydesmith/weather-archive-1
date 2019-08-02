package io.javasmithy.weather;

import java.net.URL;
import java.net.MalformedURLException;

import java.io.InputStream;
import java.io.IOException;

public class RemoteServiceAccessor {
    private URL currentObvsStation;

    public RemoteServiceAccessor(String stationId) throws MalformedURLException {
        this.currentObvsStation = new URL("https://w1.weather.gov/xml/current_obs/"+stationId+".rss");
    }

    public InputStream getCurrentObservation() throws IOException{
        return this.currentObvsStation.openStream();
    }
}