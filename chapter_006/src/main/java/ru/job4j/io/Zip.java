package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    List<File> list;
    public void pack(List<File> sources, File target) {

        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<File> seekBy(String root, String ext) {
        List<File> list = new ArrayList();
        File file = new File(root);
            File[] allFiles = file.listFiles();
             for(File el :allFiles) {
                 if (!el.isDirectory()){
                     if (el.getName().split("\\.")[1].equals(ext)) {
                         list.add(el);
                     }
                 } else {
                     seekBy(el.getName(), ext);
                 }
             }

        return list;
    }


    public static void main(String[] args) {
        new Zip().pack(List.of(new File("./chapter_005/pom.xml")), new File("./chapter_005/pom.zip"));
    }
}
