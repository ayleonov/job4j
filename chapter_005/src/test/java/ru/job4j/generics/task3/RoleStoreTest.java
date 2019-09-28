package ru.job4j.generics.task3;

import org.junit.Test;


import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class RoleStoreTest {

    @Test(expected = NoSuchElementException.class)
    public void whenAddRoleWithId0001() {
        RoleStore rs = new RoleStore();
        Base model = new Role("0001");
        rs.add(model);
        Iterator it = rs.getSimpArr().iterator();
        assertThat(rs.getSimpArr().getArray()[0], is(model));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(model));
        assertThat(it.hasNext(), is(false));
        it.next();
        rs.add(model);
        Base model2 = new Role("0002");
        assertThat(rs.getSimpArr().getArray()[0], is(model));
    }

    @Test
    public void whenAddId0002ThenModel2() {
        RoleStore rs = new RoleStore();
        Base model = new Role("0001");
        rs.add(model);
        Base model2 = new Role("0002");
        rs.add(model2);
        int result = rs.findIndexById("0002");
        assertThat(result, is(1));
        Base result2 = rs.findById("0002");
        assertThat(result2, is(model2));
    }

    @Test
    public void whenReplaceRoleInArray() {
        RoleStore rs = new RoleStore();
        Base model = new Role("0001");
        rs.add(model);
        assertThat(rs.getSimpArr().getArray()[0], is(model));
        Base model2 = new Role("0002");
        boolean result = rs.replace("0001", model2);
        assertThat(rs.getSimpArr().getArray()[0], is(model2));
        assertThat(result, is(true));
        assertThat(rs.replace("0009", model2), is(false));
    }

    @Test
    public void whenRemoveThenTrueAndShiftElements() {
        RoleStore rs = new RoleStore();
        Base model = new Role("0001");
        Base model2 = new Role("0002");
        Base model3 = new Role("0003");
        rs.add(model);
        rs.add(model2);
        rs.add(model3);
        assertThat(rs.getSimpArr().getArray()[0], is(model));
        assertThat(rs.getSimpArr().getArray()[1], is(model2));
        boolean result = rs.getSimpArr().remove(1);
        assertThat(rs.getSimpArr().getArray()[1], is(model3));
        assertThat(result, is(true));
        boolean result2 = rs.delete("0001");
        assertThat(result2, is(true));
        assertThat(rs.getSimpArr().getArray()[0], is(model3));

    }

    @Test
    public void whenTryReplaceElementWhichIsNot() {
        RoleStore rs = new RoleStore();
        Base model = new Role("0001");
        rs.add(model);
        Base model2 = new Role("0002");
        boolean result = rs.replace("0009", model2);
        assertThat(result, is(false));
    }

    @Test
    public void whenTryRemoveElementWhichIsNot() {
        RoleStore rs = new RoleStore();
        Base model = new Role("0001");
        Base model2 = new Role("0002");
        rs.add(model);
        rs.add(model2);
        assertThat(rs.delete("0001"), is(true));
        rs.delete("0009");
        assertThat(rs.delete("0009"), is(false));
        assertThat(rs.getSimpArr().getArray()[0], is(model2));
    }
}
