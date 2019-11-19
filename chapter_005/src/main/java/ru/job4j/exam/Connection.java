package ru.job4j.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Connection {
    private String source;
    private String target;
    private Map<Integer, Set> parts = new HashMap();
    private List<StringBuilder> groups = new ArrayList();

    public Connection(String source, String target) {
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
                writeInMap(currString);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void writeInMap(String received) {
        int numberconnect = checkconnection(received);
        if (numberconnect != -1) {
            StringBuilder sb = groups.get(numberconnect);
            sb.append(received);
            groups.add(numberconnect, sb);

        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(received);
            groups.add(sb);
        }
    }

    public int checkconnection(String strings) {
        int res = -1;
        // текущая поступившая строка
        String[] dStrings = strings.split(";");


        for (int i = 0; i < parts.size(); i++) {
            if (parts.get(i).contains(dStrings[0])) {
                res = i;
                saveInSet(i,dStrings);
                break;
            } else if (parts.get(i).contains(dStrings[1])) {
                res = i;
                saveInSet(i,dStrings);
                break;
            } else if (parts.get(i).contains(dStrings[2])) {
                res = i;
                saveInSet(i,dStrings);
                break;
            }

        }

        /*for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).toString().indexOf(dStrings[0]) != -1) {
                res = i;
                break;
            } else if (groups.get(i).toString().indexOf(dStrings[1]) != -1) {
                res = i;
                break;
            } else if (groups.get(i).toString().indexOf(dStrings[2]) != -1) {
                res = i;
                break;
            }
        }*/
        return res;
    }

    public void saveInSet(int i, String[] arr){
         Set<String> temp = parts.get(i);
        for (int j = 0; j < 3; j++) {
            temp.add(arr[j]);
        }
        parts.put(i, temp);
    }

    private void writeGroups() {
        try (PrintWriter out = new PrintWriter(target)) {
            for (int i = 0; i < parts.size(); i++) {
                out.println("Группа " + (i + 1));
                String[] a = parts.get(i).toString().split(";");
                int b = a.length / 3;
                for (int j = 0; j < b; j++) {
                    int c = 3 * j;
                    out.println(String.format("%s;%s;%s", a[c], a[c + 1], a[c + 2]));
                    out.flush();
                }
                out.println("");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Map<Integer, Set> getParts() {
        return parts;
    }

    public List<StringBuilder> getGroups() {
        return groups;
    }
}