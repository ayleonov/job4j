package ru.job4j.advgenerator;

import java.util.Map;

public interface IGenerator {
    String generate(String template, Map<String, String> map);
}
