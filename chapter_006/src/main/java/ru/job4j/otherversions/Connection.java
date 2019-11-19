package ru.job4j.otherversions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Connection {
    private String source;
    private String target;
    private List<String[]> arrayofstringslist = new ArrayList<>();
    private List<String[]> group1 = new ArrayList<>();
    private List<List<String[]>> groups = new ArrayList();
    int numberGroup = 1;

    public Connection(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public void start() {
        readStrings();
        accumulationInGroups();
        writeGroups();
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


    public void readStrings() {

        try (
                BufferedReader br = new BufferedReader(new FileReader(source))) {
            while (br.ready()) {
                String str = br.readLine();
                if (!str.isEmpty() && (!str.startsWith("//")) && (!str.startsWith("//"))) {
                    arrayofstringslist.add(stringToArray(str));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] stringToArray(String str) {
        String[] res = str.split(";");
        return res;
    }

    public List<List<String[]>> getGroups() {
        return groups;
    }

    public boolean comparisionStrings(String[] arr1, String[] arr2) {
        boolean res = false;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    public List<String[]> getArrayofstringslist() {
        return arrayofstringslist;
    }

    public void accumulationInGroups() {
        //коэффициент "already" alr = 1 если строке уже найдена связь, alr = 0 если связь пока не найдена
        int alr = 0;
        groups.add(group1);
        group1.add(arrayofstringslist.get(0));
        arrayofstringslist.remove(0);

        for (int i = 0; i < arrayofstringslist.size(); i++) {
            alr = 0;

            for (int j = 0; j < groups.size(); j++) {
                if (alr == 1) {
                    break;
                }
                int size = groups.get(j).size();
                for (int k = 0; k < size; k++) {
                    if (comparisionStrings(arrayofstringslist.get(i), groups.get(j).get(k))) {
                        groups.get(j).add(arrayofstringslist.get(i));
                        alr = 1;
                        break;
                    }
                }
            }
            if (alr == 0) {
                groups.add(new ArrayList<>());
                numberGroup++;
                groups.get(numberGroup - 1).add(arrayofstringslist.get(i));
            }
        }
    }
}



