package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void whenReceiveClass10AFrom70To100() {
        School school = new School();
        Student st1 = new Student(20, "", "");
        Student st2 = new Student(30, "", "");
        Student st3 = new Student(70, "", "");
        Student st4 = new Student(80, "", "");

        List<Student> students = List.of(st1, st2, st3, st4);
        Predicate<Student> predicate = student -> (student.getScore() >= 70 && student.getScore() <= 100);
        List<Student> result = school.collect(students, predicate);
        assertThat(result, is(List.of(st3, st4)));
    }

    @Test
    public void whenReceiveClass10BFrom50To70() {
        School school = new School();
        Student st1 = new Student(20, "", "");
        Student st2 = new Student(50, "", "");
        Student st3 = new Student(70, "", "");
        Student st4 = new Student(80, "", "");

        List<Student> students = List.of(st1, st2, st3, st4);
        Predicate<Student> predicate = student -> (student.getScore() >= 50 && student.getScore() < 70);
        List<Student> result = school.collect(students, predicate);
        assertThat(result, is(List.of(st2)));
    }

    @Test
    public void whenReceiveClass10CFrom0To50() {
        School school = new School();
        Student st1 = new Student(20, "", "");
        Student st2 = new Student(30, "", "");
        Student st3 = new Student(70, "", "");
        Student st4 = new Student(80, "", "");

        List<Student> students = List.of(st1, st2, st3, st4);
        Predicate<Student> predicate = student -> (student.getScore() >= 0 && student.getScore() < 50);
        List<Student> result = school.collect(students, predicate);
        assertThat(result, is(List.of(st1, st2)));
    }

    @Test
    public void whenConvertingListStudentsToMap() {
        School school = new School();
        Student st1 = new Student(20, "name1", "surname1");
        Student st2 = new Student(30, "name2", "surname2");
        Student st3 = new Student(70, "name3", "surname3");
        Student st4 = new Student(80, "name4", "surname4");

        List<Student> students = List.of(st1, st2, st3, st4);
        Map<String, Student> expect = new HashMap<>();
        expect.put(st1.getSurname(), st1);
        expect.put(st2.getSurname(), st2);
        expect.put(st3.getSurname(), st3);
        expect.put(st4.getSurname(), st4);

        Map<String, Student> result = school.collectMap(students);
        assertThat(result, is(expect));
    }

    @Test
    public void whenConvertingListStudentsToMapWithoutRepeats() {
        School school = new School();
        Student st1 = new Student(20, "name1", "surname1");
        Student st2 = new Student(30, "name2", "surname2");
        Student st3 = new Student(70, "name3", "surname3");
        Student st2d = st2;
        Student st4 = new Student(80, "name4", "surname4");

        List<Student> students = List.of(st1, st2, st3, st2d, st4);
        Map<String, Student> expect = new HashMap<>();
        expect.put(st1.getSurname(), st1);
        expect.put(st2.getSurname(), st2);
        expect.put(st3.getSurname(), st3);
        expect.put(st4.getSurname(), st4);

        Map<String, Student> result = school.collectMap2(students);

        assertThat(result, is(expect));
        assertThat(result.size(), is(4));
    }
}
