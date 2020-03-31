package ru.job4j.AdvSimpleGenerator;

import java.util.Map;
import java.util.NoSuchElementException;

public class Generator implements IGenerator {

    @Override
    public String produce(String template, Map<String, String> args) {

        String res = template;

        if (args.size() == 0) {
            throw new NoSuchElementException();
        }
        for (Map.Entry<String, String> pair : args.entrySet()) {

            int indexBeginSearchingWord = res.indexOf(pair.getKey());

            if (indexBeginSearchingWord <= -1) {
                throw new NoSuchElementException();
            }

            res = res.substring(0, indexBeginSearchingWord) + pair.getValue() +
                    res.substring(indexBeginSearchingWord + pair.getKey().length());
        }
        return res;
    }
}
