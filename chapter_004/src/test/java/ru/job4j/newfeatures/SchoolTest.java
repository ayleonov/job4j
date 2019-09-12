package ru.job4j.newfeatures;

import org.junit.Test;
import ru.job4j.newfeatures.School;
import ru.job4j.newfeatures.Student;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class SchoolTest {
    @Test
    public void when() {
        School sn = new School();

        Student st1 = new Student(45, "name1");
        Student st2 = new Student(75, "name2");
        Student st3 = new Student(65, "name3");
        Student st4 = new Student(80, "name4");

        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);

        // неверная версия - immutableCollection:
        //List<Student> students = List.of(st1, st2, st3, st4);


        List<Student> result = sn.levelOf(students, 70);
        List<Student> expect = List.of(st4, st2);
        assertThat(result, is(expect));
    }
}
