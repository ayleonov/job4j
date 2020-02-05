package ru.job4j.proba10_001;

import java.rmi.NoSuchObjectException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        //System.out.println(new Main().firstVersionStart());
        //System.out.println(new Main().secondVersionStart());
        Map<String, String> changing = new HashMap();
        changing.put("washes", "kills");
        System.out.println(new Main().generate("Mother washes a cat", changing));
    }

    public String firstVersionStart() {
        String text = "Mother washes a cat.";
        String newText = "kills";
        int lengthNew = newText.length();
        int indexBeginSearchingWord = text.indexOf("washes");

        String textBefore = text.substring(0, indexBeginSearchingWord);
        String textAfter = text.substring(indexBeginSearchingWord + lengthNew + 1);
        //System.out.println(textBefore + newText + textAfter);
        return textBefore + newText + textAfter;
    }

    public String secondVersionStart() {
        String text = "Mother washes a cat.";
        int indexBeginSearchingWord = text.indexOf("washes");
        String textBefore = text.substring(0, indexBeginSearchingWord);

        String newText = "kills";
        int lengthNew = newText.length();

        String textAfter = text.substring(indexBeginSearchingWord + lengthNew + 1);
        String[] arr = new String[3];
        arr[0] = textBefore;
        arr[1] = newText;
        arr[2] = textAfter;
        String res = "";
        for (String el : arr) {
            res += el;
        }
        return res;
    }

    public String generate(String template, Map<String, String> map) {
        String textBefore = "";
        String textAfter = "";
        String newText = "";
        String res = template;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (map.size() == 0){
                throw new NoSuchElementException();
            }
            int indexBeginSearchingWord = res.indexOf(pair.getKey());
            if (indexBeginSearchingWord > -1) {
                textBefore = res.substring(0, indexBeginSearchingWord);
                newText = pair.getValue();
                int lengthNew = newText.length();
                textAfter = template.substring(indexBeginSearchingWord + lengthNew + 1);
                res = textBefore + newText + textAfter;
            }   else {
                throw new NoSuchElementException();
            }
        }
        return res;
    }
}
