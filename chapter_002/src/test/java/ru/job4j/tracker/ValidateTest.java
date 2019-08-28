package ru.job4j.tracker;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateTest {

    private final PrintStream out = System.out;
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(System.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"invalid", "1"}));
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        input.ask("ENTER", (temp));
        assertThat(this.mem.toString(), is(
                String.format("Please enter valid date: %n")
                )
        );
    }

	@Test
	public void whenWrongInputNumber() {
		ValidateInput input = new ValidateInput(new StubInput(new String[]{"9", "1"}));
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        input.ask("ENTER", (temp));
        assertThat(this.mem.toString(), is(
                String.format("Please select key from menu:%n")
                )
        );
	}


}
