package ru.job4j.pseudo;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput(){
        System.out.println("execute before method");
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput(){
        System.setOut(stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenDrawSquare() {

        new Paint().draw(new Square());
        assertThat(new String(out.toByteArray()), is(new StringBuilder("\n")
                .append("XXXX\n")
                .append("X  X\n")
                .append("X  X\n")
                .append("XXXX\n")
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void whenDrawTriangle() {

        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()), is(new StringBuilder("\n")
                .append("   X   \n")
                .append("  X X  \n")
                .append(" X   X \n")
                .append("XXXXXXX\n")
                .append(System.lineSeparator())
                .toString()));
    }
}