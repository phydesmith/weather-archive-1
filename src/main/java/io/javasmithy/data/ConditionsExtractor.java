package io.javasmithy.data;

import java.net.URL;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/*
import javax.print.Doc;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Entity;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.*;
*/

public class ConditionsExtractor{

    public static String getWeatherConditions(String station) {

        String stationId = station;
        String weatherConditions = "";
        String wind = "";
        URL stationURL;
        
        try {
            stationURL = new URL("https://w1.weather.gov/xml/current_obs/"+stationId+".rss");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(stationURL.openStream());

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