package ru.job4j.sorting;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class SortUserTest {
    @Test
    public void whenAges32222420Then20222432() {
        SortUser user = new SortUser();

        User user1 = new User("", 32);
        User user2 = new User("", 22);
        User user3 = new User("", 24);
        User user4 = new User("", 20);
        List<User> list = List.of(user1, user2, user3, user4);

        Set<User> set = user.sort(list);
        User[] result = new User[4];
        set.toArray(result);
        assertThat(result, is(new User[]{user4, user2, user3, user1}));
    }

    @Test
    public void whenSortingWithNamesLength() {
        SortUser temp = new SortUser();
        List<User> list = new ArrayList<>();
        User firstuser = new User("Сергей", 25);
        User seconduser = new User("Алексей", 23);
        User thirduser = new User("Иван", 24);
        User fourthuser = new User("Анатолий", 23);
        list.add(firstuser);
        list.add(seconduser);
        list.add(thirduser);
        list.add(fourthuser);
        List<User> result = temp.sortNameLength(list);
        User[] resultArr = result.toArray(new User[4]);

        assertThat(resultArr, is(new User[]{thirduser, firstuser, seconduser, fourthuser}));
    }

    @Test
    public void whenSortingWithLexicographAge() {
        User us1 = new User("Сергей", 25);
        User us2 = new User("Иван", 23);
        User us3 = new User("Иван", 24);
        User us4 = new User("Сергей", 23);
        List<User> list = new ArrayList<>();
        list.add(us1);
        list.add(us2);
        list.add(us3);
        list.add(us4);
        List<User> listSorted = new SortUser().sortByAllFields(list);
        List<User> expected = new ArrayList<>();
        expected.add(us2);
        expected.add(us3);
        expected.add(us4);
        expected.add(us1);

        assertThat(listSorted, is(expected));
    }
}