package ru.job4j.tracker.tasks.lambda;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int score;
    private String surname;

    public Student(String surname, int score) {
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score && surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return getSurname() + " " + getScore();
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.getScore(), o.getScore());
    }
}
