package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        // проверяем наличие узла, который должен там быть
        assertThat(tree.findBy(6).isPresent(), is(true));
        // проверяем отсутствие узла, которого не должно быть
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTestingIterator() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        Iterator it = tree.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(((Node) it.next()).getValue(), is(1));
        it.hasNext();
        assertThat(it.hasNext(), is(true));
        assertThat(((Node) it.next()).getValue(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(((Node) it.next()).getValue(), is(3));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void whenTestingBinaryTreeThenTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(4, 5);
        // проверяем, что дерево бинарное

        assertTrue(tree.isBinary());
    }

    @Test
    public void whenTestingNotBinaryTreeThenFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        // проверяем, что дерево не бинарное
        assertFalse(tree.isBinary());
    }
}