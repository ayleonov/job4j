package ru.job4j.proba10_001;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().firstVersionStart());
        System.out.println(new Main().secondVersionStart());
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

}
