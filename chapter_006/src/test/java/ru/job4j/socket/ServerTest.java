package ru.job4j.socket;

import com.google.common.base.Joiner;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServerTest {
    private static final String LN = System.getProperty("line.separator");
    private Socket socket;
    private ByteArrayInputStream in;
    private ByteArrayOutputStream out;

    @Before
    public void beforeTest() {
        socket = mock(Socket.class);
    }

    public void interActs(ByteArrayInputStream in) throws IOException {
        out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
    }

    @Test
    public void whenReceiveAnswerOnAskExit() throws IOException {
        in = new ByteArrayInputStream("exit".getBytes());
        interActs(in);
        assertThat(out.toString(), is(new StringBuilder("exit the program").append(System.lineSeparator()).toString()));
    }

    @Test
    public void whenAskHelloThenReceiveHelloIAmOracle() throws IOException {
        in = new ByteArrayInputStream(new StringBuilder("Hello oracle").append("\n").append("exit").append(System.lineSeparator()).toString().getBytes());
        interActs(in);
        assertThat(out.toString(), is(new StringBuilder("Hello, dear friend, I'm a oracle.").append(System.lineSeparator()).append(System.lineSeparator()).append("exit the program").append(System.lineSeparator()).toString()));
    }

    @Test
    public void whenAskHelloThenReceiveHelloIAmOracle2() throws IOException {
        in = new ByteArrayInputStream(String.format("Hello oracle%sexit", System.getProperty("line.separator")).getBytes());
        interActs(in);
        assertThat(out.toString(), is(new StringBuilder("Hello, dear friend, I'm a oracle.").append(System.lineSeparator()).append(System.lineSeparator()).append("exit the program").append(System.lineSeparator()).toString()));
    }

    @Test
    public void whenAskHelloThenReceiveHelloIAmOracle3() throws IOException {
        in = new ByteArrayInputStream(
                Joiner.on(LN).join(
                        "Hello oracle",
                        "exit"
                ).getBytes());
        interActs(in);
        assertThat(out.toString(), is(Joiner.on(LN).join(
                "Hello, dear friend, I'm a oracle.",
                "",
                "exit the program",
                ""
        )));
    }

    @Test
    public void whenAskUnknownThenReceiveDontUnderstand() throws IOException {
        in = new ByteArrayInputStream(
                Joiner.on(LN).join(
                        "Unknown phrase",
                        "exit"
                ).getBytes());
        interActs(in);
        assertThat(out.toString(), is(new StringBuilder("I don't understand").append(System.lineSeparator()).append("exit the program").append(System.lineSeparator()).toString()));
    }

    @Test
    public void whenAskUnknownThenReceiveDontUnderstand2() throws IOException {
        in = new ByteArrayInputStream(
                Joiner.on(LN).join(
                        "Unknown phrase",
                        "exit"
                ).getBytes());
        interActs(in);
        assertThat(out.toString(), is(Joiner.on(LN).join(
                "I don't understand",
                "exit the program",
                ""
        )));
    }

}