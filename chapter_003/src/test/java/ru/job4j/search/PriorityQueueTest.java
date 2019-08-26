package ru.job4j.search;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();

        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenMiddlePriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.take();
        Task result = queue.take();

        assertThat(result.getDesc(), is("middle"));
    }

    @Test
    public void whenLowPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.take();
        queue.take();
        Task result = queue.take();

        assertThat(result.getDesc(), is("low"));
    }
}