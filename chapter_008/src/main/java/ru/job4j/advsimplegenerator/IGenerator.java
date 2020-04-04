package ru.job4j.advsimplegenerator;

import java.util.Map;

public interface IGenerator {
    String produce(String template, Map<String, String> args);
}
