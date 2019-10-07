package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ResearchTest {
    Research rs = new Research();
    User u1;
    User u2;

    @Before
    public void BeforeTest() {
        Research rs = new Research();

        u1 = new User("Иван", 1, null);
        u2 = new User("Иван", 1, null);
    }

    @Test
    public void whenCreatedUsersWithoutOverrideEquals() {
        rs.getMap().put(u1, "17");
        rs.getMap().put(u2, "19");
        System.out.println(rs.getMap());
        int hash1 = rs.getMap().get(u1).hashCode();
        int hash2 = rs.getMap().get(u2).hashCode();
        System.out.println(u1.hashCode()==u2.hashCode());
        assertThat(u1.hashCode()==u2.hashCode(), is(true));
        assertThat(rs.getMap().size(), is(1));
        assertThat(rs.getMap().get(u2), is("19"));
        assertThat(u1.equals(u2), is(true));
    }

    @Test
    public void whenCreatedUsersWithoutOverrideEquals2() {
        rs.researching();
    }
}
