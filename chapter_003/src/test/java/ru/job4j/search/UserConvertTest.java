package ru.job4j.search;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class UserConvertTest {
    @Test
    public void whenListConvertToMap() {
        User userFirst = new User();
        User userSecond = new User();
        User userThird = new User();
        List<User> list = new ArrayList();
        list.add(userFirst);
        list.add(userSecond);
        list.add(userThird);

        UserConvert user = new UserConvert();
        HashMap<Integer, User> result = user.process(list);

        HashMap<Integer, User> expect = new HashMap<>();
        Integer idUser1 = user.getListids().get(0);
        Integer idUser2 = user.getListids().get(1);
        Integer idUser3 = user.getListids().get(2);
        expect.put(idUser1, userFirst);
        expect.put(idUser2, userSecond);
        expect.put(idUser3, userThird);
        assertThat(result, is(expect));
    }
}