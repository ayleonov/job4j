package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenDrawSquare1() {
        Square square = new Square();
        assertThat(square.draw(), is(new StringBuilder("\n")
                .append("XXXX\n")
                .append("X  X\n")
                .append("X  X\n")
                .append("XXXX\n")
                .toString()));
    }    
}