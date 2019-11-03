package ru.job4j.socket;

import com.google.common.base.Joiner;

import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServerTest2 {
    private static final String LN = System.getProperty("line.separator");

    public void testServer(String input, String expected) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Socket socket = mock(Socket.class);
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is(expected));
    }


    @Test
    public void whenReceiveAnswerOnAskExit() throws IOException {
        testServer("exit", Joiner.on(LN).join(
                "exit the program",
                ""
        ));
    }

    @Test
    public void whenAskHelloThenReceiveHelloIAmOracle() throws IOException {
        testServer(Joiner.on(LN).join(
                "Hello oracle",
                "exit"
                ),
                Joiner.on(LN).join(
                        "Hello, dear friend, I'm a oracle.",
                        "",
                        "exit the program",
                        ""
                ));
    }


    @Test
    public void whenAskUnknownThenReceiveDontUnderstand() throws IOException {
        testServer(Joiner.on(LN).join(
                "Unknown phrase",
                "exit"
                ),
                Joiner.on(LN).join(
                        "I don't understand",
                        "exit the program",
                        ""
                ));
    }


    @Test
    public void whenAskUnknownThenReceiveDontUnderstand2() throws IOException {
        testServer(Joiner.on(LN).join(
                "Unknown phrase",
                "exit"
                ),
                Joiner.on(LN).join(
                        "I don't understand",
                        "exit the program",
                        ""
                ));

    }
}