package ru.job4j.sql.sqlite;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ParserXML {

    public void startParsing(File source) {
        SAXParserFactory factory = SAXParserFactory.newDefaultInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        SAXParse sp = new SAXParse();
        try {
            parser.parse(source,sp);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXParse extends DefaultHandler {
    private int res = 0;
    private String element = "";
    private int id = -1;
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("start parsing...");

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        element = qName;
        if (element.equals("entry")){
            res += Integer.parseInt(attributes.getValue(0));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String str = "";
        for (int i = 0; i < 2 ; i++) {
            str += ch[start + i];
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        id = -1;
        element = "";


    }

    @Override
    public void endDocument() throws SAXException {
        super.startDocument();
        System.out.println("result: " + res);
        System.out.println("end parsing...");

    }
}
