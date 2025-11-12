package edu.acceso.testpath;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Main {


    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);

        URL url = Main.class.getResource("/files/caca.xml");
        try(InputStream st = url.openStream()) {
            DocumentBuilder builder = factory.newDocumentBuilder();

            builder.setEntityResolver(new MiEntityResolver());

            Document xml = builder.parse(st, url.toString());

            System.out.println(xml.getDocumentElement().getTagName());
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}