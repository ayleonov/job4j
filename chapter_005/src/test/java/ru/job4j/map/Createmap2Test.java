package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ru.job4j.map.Createmap2.Entry;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Createmap2Test<K, V> {
    @Test
    public void whenInsertTwoEqualElementResultTrueThenFalse() {
        Createmap2 pr = new Createmap2();
        assertThat(pr.insert("third", 17), is(true));
        assertThat(pr.getTable()[13].getKey(), is("third"));
        assertThat(pr.insert("third", 17), is(false));
    }

    @Test
    public void whenGetByKeyInsertedElements() {
        Createmap2 pr = new Createmap2();
        pr.insert("first", 17);
        pr.insert("second", 1127);
        assertThat(pr.get("first"), is(17));
        assertThat(pr.get("second"), is(1127));
    }

    @Test
    public void whenGetElementWhoseKeyIsNull() {
        Createmap2 pr = new Createmap2();
        pr.insert("first", 17);
        pr.insert(null, 1127);
        assertThat(pr.get("first"), is(17));
        System.out.println(pr.get(null));
        assertThat(pr.get(null), is(1127));
    }

    @Test
    public void whenDeleteExistAndNonExistElement() {
        Createmap2 pr = new Createmap2();
        pr.insert("first", 17);
        pr.insert("second", 1127);
        pr.insert("second", 1127);
        pr.insert("third", 1322);
        //проверяем что разместилось 3 элемента
        assertThat(pr.getPosition(), is(3));
        // проверяем, что элемент найден и удален
        assertThat(pr.delete("first"), is(true));
        // проверяем, что ключ не найден
        assertThat(pr.delete("fir"), is(false));
        // проверяем, что после удаления осталось 2 элемента
        assertThat(pr.getPosition(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTestingIterator() {
        Createmap2 pr = new Createmap2();
        pr.insert("first", 17);
        pr.insert("second", 1127);
        Iterator it = pr.iterator();

        assertThat(it.hasNext(), is(true));

        //System.out.println((Entry<K,V>)(it.next()));
        Entry result = (Entry<K, V>) (it.next());
        assertThat(result.getKey(), is("second"));
        assertThat(result.getValue(), is(1127));

        assertThat(it.hasNext(), is(true));

        Entry result2 = (Entry<K, V>) (it.next());
        assertThat(result2.getKey(), is("first"));
        assertThat(result2.getValue(), is(17));

        assertThat(it.hasNext(), is(false));
        it.next();
    }
}