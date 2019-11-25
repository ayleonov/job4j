package ru.job4j.sql.sqlite;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import ru.job4j.sql.sqlite.XmlUsage.Entry;
import java.util.List;
import ru.job4j.sql.sqlite.XmlUsage.Field;


public class StoreXML {
    File target;

    public StoreXML(File target) {
        this.target = target;
    }

    public File save(List<Field> list) {
        File res = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entry.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(new Entry(list), target);
            jaxbMarshaller.marshal(new Entry(list), System.out);

        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }   finally {

        }
        res = target;
        return res;
    }
}
