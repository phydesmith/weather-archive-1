package io.javasmithy.weather;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.SAXException;

import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

public class DataParser {
    private DocumentBuilderFactory dbf;
    private DocumentBuilder db;
    private Document doc;
    private Map<String,String> data;

    public DataParser(InputStream stationData) {
        createDocBuilder();
        createDocument(stationData);
        data = new HashMap<String,String>();
        getAllTextData(doc.getFirstChild());
        concatTextData();
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

    private void getAllTextData(Node node){
        if (node.getNodeType() == Node.TEXT_NODE) {
            data.put( node.getParentNode().getParentNode().getNodeName()+"."+node.getParentNode().getNodeName(), node.getNodeValue());
        }
        if (node.hasChildNodes()) {
            getAllTextData(node.getFirstChild());
        }
        if (node.getNextSibling() != null) {
            getAllTextData(node.getNextSibling());
        }
    }

    public String concatTextData(){
        String dataString = "";
        for (Map.Entry<String, String> entry : data.entrySet()) {
            dataString += "\n" + entry.getKey() + ":\t" + entry.getValue();
        }
        return dataString;
    }

