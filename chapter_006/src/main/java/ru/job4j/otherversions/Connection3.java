package ru.job4j.otherversions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Connection3 {
    private String source;
    private String target;
    private Map<Integer, List<String[]>> groups = new HashMap();
    //private Map<Integer, TreeSet<String[]>> groups2 = new HashMap();

    public Connection3(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public void start() {
        readStrings();
        writeGroups();
    }

    public void readStrings() {
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            while (br.ready()) {
                String currString = br.readLine();
                writeInMap(currString.split(";"));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void writeInMap(String[] received) {
        int numberconnect = checkconnection(received);
        if (numberconnect != -1) {
            List list = groups.get(numberconnect);
            list.add(received);
            groups.put(numberconnect, list);

        } else {
            List<String[]> list = new ArrayList<>();
            list.add(received);
            groups.put(groups.size(), (list));
        }
    }

    public int checkconnection(String[] strings) {
        int res = -1;
        // i - группы   j - строки по 3 шт
        for (int i = 0; i < groups.size(); i++) {
            for (int j = 0; j < groups.get(i).size(); j++) {
                for (int k = 0; k < 3; k++) {
                    String a = groups.get(i).get(j)[k];
                    if (groups.get(i).get(j)[k].equals(strings[0])) {
                        res = i;
                    } else if (groups.get(i).get(j)[k].equals(strings[1])) {
                        res = i;
                    } else if (groups.get(i).get(j)[k].equals(strings[2])) {
                        res = i;
                    }
                }
            }
        }
        return res;
    }

    private void writeGroups() {
        try (PrintWriter out = new PrintWriter(target)) {
            for (int i = 0; i < groups.size(); i++) {
                out.println("Группа " + (i + 1));
                List<String[]> obj = groups.get(i);
                for (int j = 0; j < obj.size(); j++) {
                    String[] summ = obj.get(j);
                    out.println(String.format("%s;%s;%s", summ[0], summ[1], summ[2]));
                    out.flush();
                }
                out.println("");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Map<Integer, List<String[]>> getGroups() {
        return groups;
    }
}