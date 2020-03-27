package ru.job4j.advgenerator;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class MainTest {
    @Test
    public void when() {
        IGenerator generator = new AdvancedSimpleGenerator();
        Map<String, String> map = ((AdvancedSimpleGenerator)generator).getMap();
        Map<String,String> mapTest = new HashMap();
        String template = "I am a ${name}, Who are ${subject}? ";
        mapTest.put("Aleksey", "you");
        String expected = "I am a Aleksey, Who are you? ";
        String res = generator.generate(template, mapTest);
        assertThat(res, is(expected));
    }
}