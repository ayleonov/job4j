package ru.job4j.proba10_001;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;


public class TemplateTest {
    @Test
    public void when() {
     ITemplate template = new TemplateAction();
     String text = "Hello, ${name}.";
     Object[] data = new String[]{"Peter"};
     String res = template.generate(text, data);
        System.out.println(res);
        String expected = "Hello, Peter";
        assertThat(res, is(expected));
    }
}