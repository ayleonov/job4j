package ru.job4j.AdvSimpleGenerator;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class GeneratorTest {
    Map<String, String> map;
    IGenerator generator;
    String text;

    @Before
    public void beforeTest() {
        generator = new Generator();
        text = "I am a ${name}, Who are ${subject}? ";
        map = new HashMap<>();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoPairsInMapThenException() {
        generator.produce(text, map);
    }

    @Test
    public void whenNameChangedToAleksey() {
        map.put("${name}", "Aleksey");
        String correctText = "I am a Aleksey, Who are ${subject}? ";
        String res = generator.produce(text, map);
        assertThat(res, is(correctText));
    }

    @Test
    public void whenSubjectChangedToYou() {
        map.put("${subject}", "you");
        String correctText = "I am a ${name}, Who are you? ";
        String res = generator.produce(text, map);
        assertThat(res, is(correctText));
    }

    @Test
    public void whenNameChangedToAlekseySubjectoToYou() {
        map.put("${name}", "Aleksey");
        map.put("${subject}", "you");
        String correctText = "I am a Aleksey, Who are you? ";
        String res = generator.produce(text, map);
        assertThat(res, is(correctText));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenHereExcessKeyInMapThenException() {
        map.put("excess key", "Aleksey");
        generator.produce(text, map);
    }

}