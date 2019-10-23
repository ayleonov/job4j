package ru.job4j.analize;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import ru.job4j.analize.Analize.User;
import ru.job4j.analize.Analize.Info;

import java.util.List;

public class AnalizeTest {
    Analize an;
    Info result;

    @Before
    public void beforeTest() {
        Analize an = new Analize();
        User us1 = new User(1, "user1");
        User us2 = new User(2, "user2");
        User us3 = new User(3, "user3");
        User us4 = new User(4, "user4");

        User us5 = new User(1, "user1a");
        User us8 = new User(5, "user5");
        User us9 = new User(6, "user6");
        User us19 = new User(7, "user7");
        User us24 = new User(4, "user4a");


        List<User> prev = List.of(us1, us2, us3, us4);
        List<User> curr = List.of(us5, us8, us3, us9, us19, us24);
        result = an.diff(prev, curr);
    }
    @Test
    public void whenTestintThatChangedTwoUsers() {

        assertThat(result.getChanged(), is(2));
    }

    @Test
    public void whenTestintThatDeletedOneUser() {
        assertThat(result.getDeleted(), is(1));
    }
    @Test
    public void whenTestThatAddedThreeUsers() {
        assertThat(result.getAdded(), is(3));
    }
}