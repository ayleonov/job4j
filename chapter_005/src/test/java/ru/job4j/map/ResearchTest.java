package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

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
      /*  for (Map.Entry pair : rs.getMap().entrySet()){
            System.out.println(pair); */
        assertThat(rs.getMap().size(), is(2));
        }

    @Test
    public void whenCreatedUsersWithoutOverrideEquals2() {
        rs.researching();
    }
}
