package ru.job4j.loop;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void when3x3() {
        Board board = new Board();
        String ln = System.lineSeparator();
        String result = board.print(3, 3);

        assertThat(result, is(String.format("X X%s X %sX X%s", ln, ln, ln)));

    }

    @Test
    public void when8x8() {
        Board board = new Board();
        String ln = System.lineSeparator();
        String result = board.print(8, 8);
        String line1 = "X X X X ";
        String line2 = " X X X X";

        assertThat(result, is(String.format(line1 + "%s" + line2 + "%s" + line1 + "%s" + line2 + "%s" + line1 + "%s" + line2 + "%s" + line1 + "%s" + line2 + "%s", ln, ln, ln, ln, ln, ln, ln, ln)));
    }

    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String ln = System.lineSeparator();
        String result = board.print(5, 4);

        assertThat(result, is(String.format("X X X%s X X %sX X X%s X X %s", ln, ln, ln, ln, ln, ln, ln, ln)));
    }
}
