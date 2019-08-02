package io.javasmithy.data;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

public class WeatherExtractor {
    private InputStream stationData;

    public WeatherExtractor(InputStream stationData) {
        this.stationData = stationData;
    }

    public String extractWeatherConditions(){
        String weatherConditions = "";
        String wind = "";
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(stationData);

            NodeList titleNodes = doc.getElementsByTagName("title");
            NodeList descriptionNodes = doc.getElementsByTagName("description");
            NodeList descriptionChildNodes;

            for (int i = 0; i < descriptionNodes.getLength(); i++) {
                if (descriptionNodes.item(i).hasChildNodes()) {
                    descriptionChildNodes = descriptionNodes.item(i).getChildNodes();
                    for (int c = 0; c < descriptionChildNodes.getLength(); c++) {
                        if (i == 1 && c==2) {
                            wind = descriptionChildNodes.item(2).getTextContent();
                        }
                    }
                }
            }
            
            weatherConditions += titleNodes.item(0).getTextContent()
                              +  titleNodes.item(2).getTextContent()
                              +  wind;

            return weatherConditions;

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
}