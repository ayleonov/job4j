package ru.job4j.AdvSimpleGenerator;

import java.util.Map;
import java.util.NoSuchElementException;

public class Generator implements IGenerator {

    @Override
    public String produce(String template, Map<String, String> args) {

        String textBefore;
        String textAfter;
        String templ;
        String newText;
        String res = template;
        if (args.size() == 0) {
            throw new NoSuchElementException();
        }
        for (Map.Entry<String, String> pair : args.entrySet()) {

            int indexBeginSearchingWord = res.indexOf(pair.getKey());
            if (indexBeginSearchingWord > -1) {
                textBefore = res.substring(0, indexBeginSearchingWord);
                templ = pair.getKey();
                newText = pair.getValue();
                int lengthTempl = templ.length();
                textAfter = template.substring(indexBeginSearchingWord + lengthTempl);
                res = textBefore + newText + textAfter;
            } else {
                throw new NoSuchElementException();
            }
        }
        return res;
    }
}
