package ru.job4j.sql.sqlite;


import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;


public class ConvertXSQT {
    public void convert(File source, File dest, File scheme) throws TransformerException, IOException {
        String xml = readXML(source);
        String xsl = readXML(scheme);



        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource(new ByteArrayInputStream(xsl.getBytes()))
        );

        transformer.transform(new StreamSource(new ByteArrayInputStream(xml.getBytes())), new StreamResult());
        transformer.transform(new StreamSource(dest), new StreamResult());

    }

    public String readXML(File source) {
        String xmlSource = "";
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            StringBuilder xmlSourceSB = new StringBuilder();
            while (br.ready()) {
                xmlSourceSB.append(br.readLine());
            }
            xmlSource = xmlSourceSB.toString();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return xmlSource;
    }
}
