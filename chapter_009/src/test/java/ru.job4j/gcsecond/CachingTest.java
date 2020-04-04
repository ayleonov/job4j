package ru.job4j.gcsecond;

import org.junit.Before;
import org.junit.Test;

import java.lang.ref.SoftReference;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class CachingTest {

    private Caching caching;
    private String obj1;
    private String obj2;

    @Before
    public void beforeTest() {
        caching = new Caching();
        obj1 = "232";
        obj2 = "first object";
        caching.put(obj1, obj2);
    }

    @Test
    public void whenAddObjectInCache() {
        assertThat(caching.getMap().size(), is(1));
    }

    @Test
    public void whenAddSecondTheSameObjectInCache() {
        caching.put(obj1, obj2);
        assertThat(caching.getMap().size(), is(1));
    }

    @Test
    public void whenGetObjectFromCache() {
        SoftReference res = caching.getMap().get(obj1);
        assertThat(caching.get(obj1, obj2), is(res));
    }

    @Test
    public void whenRemoveObjectFromCache() {

        caching.remove(obj1);
        assertThat(caching.getMap().size(), is(0));
    }

}