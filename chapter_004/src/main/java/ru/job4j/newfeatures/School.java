package ru.job4j.newfeatures;

import java.util.Collections;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {

    List<Student> levelOf(List<Student> students, int bound) {

        students.sort(Comparator.comparing(Student::getScore));
        Collections.reverse(students);

        return students.stream().flatMap(Stream::ofNullable).takeWhile(v -> v.getScore() > bound).collect(Collectors.toList());
    }
}
