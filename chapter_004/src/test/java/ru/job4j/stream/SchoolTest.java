package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void whenReceiveClass10AFrom70To100() {
        School school = new School();
        Student st1 = new Student(20);
        Student st2 = new Student(30);
        Student st3 = new Student(70);
        Student st4 = new Student(80);

        List<Student> students = List.of(st1, st2, st3, st4);
        Predicate<Student> predicate = student -> (student.getScore() >= 70 && student.getScore() <= 100);
        List<Student> result = school.collect(students, predicate);
        assertThat(result, is(List.of(st3, st4)));
    }

    @Test
    public void whenReceiveClass10BFrom50To70() {
        School school = new School();
        Student st1 = new Student(20);
        Student st2 = new Student(50);
        Student st3 = new Student(70);
        Student st4 = new Student(80);

        List<Student> students = List.of(st1, st2, st3, st4);
        Predicate<Student> predicate = student -> (student.getScore() >= 50 && student.getScore() < 70);
        List<Student> result = school.collect(students, predicate);
        assertThat(result, is(List.of(st2)));
    }

    @Test
    public void whenReceiveClass10CFrom0To50() {
        School school = new School();
        Student st1 = new Student(20);
        Student st2 = new Student(30);
        Student st3 = new Student(70);
        Student st4 = new Student(80);

        List<Student> students = List.of(st1, st2, st3, st4);
        Predicate<Student> predicate = student -> (student.getScore() >= 0 && student.getScore() < 50);
        List<Student> result = school.collect(students, predicate);
        assertThat(result, is(List.of(st1, st2)));
    }
}
