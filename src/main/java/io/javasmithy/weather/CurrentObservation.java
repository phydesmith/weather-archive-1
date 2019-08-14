package io.javasmithy.weather;

import java.net.MalformedURLException;
import java.io.IOException;

import io.javasmithy.weather.DataParser;

import java.util.HashMap;

public class CurrentObservation {
    private String zipCode;
    private String stationId;
    private String stationName;
    private String weatherConditions;
    private String windConditions;
    
    public CurrentObservation(String zipCode) throws IOException {
        this.zipCode = zipCode;
        this.stationId = StationLocator.findStation(this.zipCode);
        HashMap<String, String> data = new DataParser( new RemoteServiceAccessor(this.stationId).getCurrentObservation() ).getData();
        this.stationName = data.get("channel.title");
        this.weatherConditions = data.get("item.title");
        this.windConditions = data.get("item.description");
    }

    @Override
    public String toString() {
        return "Station Name: " + this.stationName
             + "\nStation Id: " + this.stationId
             + "\nZip Code:  "  + this.zipCode
             + "\nConditions: " + this.weatherConditions + "\n" + this.windConditions;
    }
}