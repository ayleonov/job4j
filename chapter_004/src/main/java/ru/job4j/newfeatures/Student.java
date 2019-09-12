package ru.job4j.newfeatures;

import java.util.Comparator;

public class Student implements Comparator<Student> {
    private final int score;
    private final String name;

    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{"
                + "score=" + score
                + ", name='" + name + '\''
                + '}';
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getScore() > o2.getScore() ? 1 : o1.getScore() == o2.getScore() ? 0 : -1;
    }
}
