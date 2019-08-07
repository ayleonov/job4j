package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TriangleTest {
    @Test
    public void whenDrawTriangle1() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(new StringBuilder("\n")
                .append("   X   \n")
                .append("  X X  \n")
                .append(" X   X \n")
                .append("XXXXXXX\n")
                .toString()));
    }   
}