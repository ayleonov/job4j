package ru.job4j.socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;


public class ClientTest {
/*    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream stdout = System.out;
    private static final String LN = System.getProperty("line.separator");

    public void testClient(String input, String expected) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Socket socket = mock(Socket.class);
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Client client = new Client(socket);
        client.start();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenReceiveAnswerOnAskExit() throws IOException {
        testClient("exit", Joiner.on(LN).join(
                "exit the program",
                ""
        ));
    }*/
}