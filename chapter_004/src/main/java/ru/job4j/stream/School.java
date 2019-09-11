package ru.job4j.stream;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        List<Student> result = students.stream().filter(predicate).collect(Collectors.toList());
        return result;
    }

    public Map<String, Student> collectMap(List<Student> students) {
        Set<Student> studentsSet = new HashSet<>();
        Map<String, Student> result = students.stream().distinct().collect(Collectors.toMap(student -> student.getSurname(), student -> student));
        return result;
    }

    public Map<String, Student> collectMap2(List<Student> students) {
        Set<Student> studentsSet = new HashSet<>();
        for (Student student : students) {
            studentsSet.add(student);
        }
        Map<String, Student> result = studentsSet.stream().collect(Collectors.toMap(student -> student.getSurname(), student -> student));

        return result;
    }

    public Map<String, Student> collectMap3(List<Student> students) {

        Map<String, Student> result = students.stream().collect(Collectors.toMap(student -> student.getSurname(), student -> student, ((student, student2) -> student)));

        return result;
    }

}
