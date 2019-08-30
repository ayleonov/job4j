package ru.job4j.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class SortUserTest {
    @Test
    public void whenAges32_22_24_20Then20_22_24_32() {
        SortUser user = new SortUser();
        List<User> list = new ArrayList<>();
        User user1 = new User("", 32);
        User user2 = new User("", 22);
        User user3 = new User("", 24);
        User user4 = new User("", 20);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        Set<User> set = user.sort(list);
        User[] result = new User[4];
        set.toArray(result);
        assertThat(result, is(new User[]{user4, user2, user3, user1}));
    }
}