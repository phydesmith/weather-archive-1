package io.javasmithy.weather;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.SAXException;

import java.util.ArrayList;

public class DataParser {
    private DocumentBuilderFactory dbf;
    private DocumentBuilder db;
    private Document doc;

    public DataParser(InputStream stationData) {
        createDocBuilder();
        createDocument(stationData);
    }

    private void createDocBuilder(){
        this.dbf = DocumentBuilderFactory.newInstance();
        try {
            this.db = this.dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println(e);
        } 
    }

    private void createDocument(InputStream stationData){
        try {
            this.doc = db.parse(stationData);
        } catch (SAXException | IOException e) {
            System.out.println(e);
        }
    }

    public String extractWeatherConditions(){
        String weatherConditions = "";
        String wind = "";
        
        ArrayList<Node> nodes = new ArrayList();

        try {
            NodeList titleNodes = this.doc.getElementsByTagName("title");
            NodeList descriptionNodes = this.doc.getElementsByTagName("description");
            NodeList descriptionChildNodes;

            for (int i = 0; i < titleNodes.getLength(); i++) {
                nodes.add(titleNodes.item(i));
            }

            for (int i = 0; i < descriptionNodes.getLength(); i++) {
                nodes.add(descriptionNodes.item(i));
            }

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