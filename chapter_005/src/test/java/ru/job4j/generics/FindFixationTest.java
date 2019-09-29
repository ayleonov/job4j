package ru.job4j.generics;


import org.junit.Test;
import ru.job4j.generics.FindFixation.Node;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FindFixationTest {
    @Test
    public void whenWithoutFixations() {
        FindFixation ff = new FindFixation();
        Node[] arrayTesting = new Node[4];
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        arrayTesting[0] = two;
        arrayTesting[1] = three;
        arrayTesting[2] = four;
        arrayTesting[3] = one;


        assertThat(ff.hasCycle(one), is(true));
    }

    @Test
    public void whenHasFixations() {
        FindFixation ff = new FindFixation();
        Node[] arrayTesting = new Node[4];
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        ff.setArrayTesting(arrayTesting);
        arrayTesting[0] = two;
        arrayTesting[1] = three;
        arrayTesting[2] = four;
        arrayTesting[3] = null;
        assertThat(ff.hasCycle(one), is(false));
    }

}