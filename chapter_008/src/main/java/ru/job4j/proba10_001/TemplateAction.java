package ru.job4j.proba10_001;

public class TemplateAction implements ITemplate {
    @Override
    public String generate(String template, Object[] data) {

        String name = "";
        int dataLength = data.length;
        String[] arr = new String[dataLength];
        for (int i = 0; i < dataLength; i++) {
            arr[i] = template + data[i];
        }
        name = arr[(int)(dataLength*Math.random())];

        return template;
    }
}
