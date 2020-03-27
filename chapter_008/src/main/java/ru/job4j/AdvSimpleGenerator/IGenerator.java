package ru.job4j.AdvSimpleGenerator;

import java.util.Map;

public interface IGenerator {
    String produce(String template, Map<String, String> args);
}
