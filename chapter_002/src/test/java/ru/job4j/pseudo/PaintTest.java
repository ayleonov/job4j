package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class PaintTest {

    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(new String(out.toByteArray()), is(new StringBuilder("\n")
                .append("XXXX\n")
                .append("X  X\n")
                .append("X  X\n")
                .append("XXXX\n")
                .append(System.lineSeparator())
                .toString()));
        System.setOut(stdout);
    }

    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()), is(new StringBuilder("\n")
                .append("   X   \n")
                .append("  X X  \n")
                .append(" X   X \n")
                .append("XXXXXXX\n")
                .append(System.lineSeparator())
                .toString()));
        System.setOut(stdout);
    }
}