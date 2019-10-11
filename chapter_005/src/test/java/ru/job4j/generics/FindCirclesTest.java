package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.generics.FindCircles.Node;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FindCirclesTest {
    FindCircles fc;
    Node first = new Node(1);
    Node two = new Node(2);
    Node third = new Node(3);
    Node four = new Node(4);

    @Before
    public void beforeTest() {
        fc = new FindCircles();
        first.next = two;
        two.next = third;
        third.next = four;
    }

    @Test
    public void whenExistCircle() {
        four.next = first;
        assertThat(fc.hasCircles(first), is(true));
    }

    @Test
    public void whenNoCircle() {
        four.next = null;
        assertThat(fc.hasCircles(first), is(false));
    }
}