package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.map.Createmap.Node;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;

public class CreatemapTest<K, V> {
    Map<K, V> map = new HashMap();
    Createmap cm;

    @Before
    public void beforeTest() {
        cm = new Createmap();
        cm.insert("Rotor", 1655);
    }

    @Test
    public void whenAddNodeInEmptyMap() {
        assertThat(cm.getPosition(), is(1));
        cm.insert("Starter", 12155);
        assertThat(cm.getPosition(), is(2));
        assertThat(cm.getTable()[0].getKey(), is("Rotor"));
        assertThat(cm.getTable()[0].getValue(), is(1655));
    }

    @Test
    public void whenAddNodeByKey() {
        assertThat(cm.getNode("Rotor"), is(cm.getTable()[0]));
    }

    @Test
    public void whenGetElementByKey() {
        assertThat(cm.get("Rotor"), is(1655));
        assertNull(cm.get("Rotor2"));
    }

    @Test
    public void whenReplaceExistElementByKey() {
        assertThat(cm.insert("Rotor", 3521), is(true));
        assertThat(cm.getTable()[0].getKey(), is("Rotor"));
        assertThat(cm.getTable()[0].getValue(), is(3521));
    }

    @Test
    public void whenDeleteElement() {
        cm.insert("Rotor2", 12155);
        cm.insert("Rotor3", 21532);
        System.out.println(cm.getPosition());
        assertThat(cm.getPosition(), is(3));
        assertThat(cm.delete("Rotor"), is(true));
        assertThat(cm.getTable()[0].getKey(), is("Rotor2"));
        assertThat(cm.getTable()[0].getValue(), is(12155));
        assertThat(cm.getTable()[1].getKey(), is("Rotor3"));
        assertThat(cm.getTable()[1].getValue(), is(21532));
        assertThat(cm.getPosition(), is(2));

        /*for (int i = 0; i < cm.getPosition() + 2; i++) {
            K key = cm.getTable()[i] == null ? null : (K) cm.getTable()[i].getKey();
            V value = cm.getTable()[i] == null ? null : (V) cm.getTable()[i].getValue();
            System.out.println(String.format("%d %s %d", i, key, value));
        }
         */
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTestingIterator() {
        Iterator it = cm.iterator();
        cm.insert("Rotor2", 1255);
        assertThat(it.hasNext(), is(true));
        Node<K, V> temp = (Node<K, V>) it.next();
        assertThat(temp.getKey(), is("Rotor"));
        assertThat(temp.getValue(), is(1655));

        assertThat(it.hasNext(), is(true));
        Node<K, V> temp2 = (Node<K, V>) it.next();
        assertThat(temp2.getKey(), is("Rotor2"));
        assertThat(temp2.getValue(), is(1255));

        assertThat(it.hasNext(), is(false));
        it.next();
    }
}