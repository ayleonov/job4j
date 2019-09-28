package ru.job4j.generics.task3;

import org.junit.Test;


import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class UserStoreTest {

    @Test(expected = NoSuchElementException.class)
    public void whenAddRoleWithId0001() {
        UserStore us = new UserStore();
        Base model = new User("0001");
        us.add(model);
        Iterator it = us.getSimpArr().iterator();
        assertThat(us.getSimpArr().getArray()[0], is(model));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(model));
        assertThat(it.hasNext(), is(false));
        it.next();
        us.add(model);
        Base model2 = new User("0002");
        assertThat(us.getSimpArr().getArray()[0], is(model));
    }

    @Test
    public void whenAddId0002ThenModel2() {
        UserStore us = new UserStore();
        Base model = new User("0001");
        us.add(model);
        Base model2 = new User("0002");
        us.add(model2);
        int result = us.findIndexById("0002");
        assertThat(result, is(1));
        Base result2 = us.findById("0002");
        assertThat(result2, is(model2));
    }

    @Test
    public void whenReplaceRoleInArray() {
        UserStore us = new UserStore();
        Base model = new User("0001");
        us.add(model);
        assertThat(us.getSimpArr().getArray()[0], is(model));
        Base model2 = new User("0002");
        boolean result = us.replace("0001", model2);
        assertThat(us.getSimpArr().getArray()[0], is(model2));
        assertThat(result, is(true));
        assertThat(us.replace("0009", model2), is(false));
    }

    @Test
    public void whenRemoveThenTrueAndShiftElements() {
        UserStore us = new UserStore();
        Base model = new User("0001");
        Base model2 = new User("0002");
        Base model3 = new User("0003");
        us.add(model);
        us.add(model2);
        us.add(model3);
        assertThat(us.getSimpArr().getArray()[0], is(model));
        assertThat(us.getSimpArr().getArray()[1], is(model2));
        boolean result = us.getSimpArr().remove(1);
        assertThat(us.getSimpArr().getArray()[1], is(model3));
        assertThat(result, is(true));
        boolean result2 = us.delete("0001");
        assertThat(result2, is(true));
        assertThat(us.getSimpArr().getArray()[0], is(model3));

    }

    @Test
    public void whenTryReplaceElementWhichIsNot() {
        UserStore us = new UserStore();
        Base model = new User("0001");
        us.add(model);
        Base model2 = new User("0002");
        boolean result = us.replace("0009", model2);
        assertThat(result, is(false));
    }

    @Test
    public void whenTryRemoveElementWhichIsNot() {
        UserStore us = new UserStore();
        Base model = new User("0001");
        Base model2 = new User("0002");
        us.add(model);
        us.add(model2);
        assertThat(us.delete("0001"), is(true));
        us.delete("0009");
        assertThat(us.delete("0009"), is(false));
        assertThat(us.getSimpArr().getArray()[0], is(model2));
    }
}