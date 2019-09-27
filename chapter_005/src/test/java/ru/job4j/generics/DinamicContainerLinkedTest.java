package ru.job4j.generics;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class DinamicContainerLinkedTest {
    private DinamicContainerLinked<Integer> dincont;
    @Before
    public void beforeTest() {
        dincont = new DinamicContainerLinked<>();
        dincont.add(1);
        dincont.add(2);
    }
    @Test
    public void whenAddTenElementsThenItInContainer() {
        dincont.add(3);
        dincont.add(4);
        dincont.add(5);
        assertThat(dincont.get(4), is(1));
        assertThat(dincont.get(3), is(2));
    }
    @Test
    public void whenAddTwoElementsThenGetSecondByIndex() {
        assertThat(dincont.get(1), is(1));
    }
    @Test(expected = NoSuchElementException.class)
    public void whenTestingHasNextAndNext() {
        Iterator it = dincont.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
