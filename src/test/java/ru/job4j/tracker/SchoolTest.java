package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.tasks.lambda.School;
import ru.job4j.tracker.tasks.lambda.Student;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void whenDiapasonFrom70To100() {
        List<Student> students = List.of(new Student(50),
                new Student(80),
                new Student(90),
                new Student(30)
        );
        List<Student> rsl = new School().collect(students,
                student -> student.getScore() >= 70 && student.getScore() <= 100);
        assertThat(rsl, containsInAnyOrder(new Student(80), new Student(90)));
    }

    @Test
    public void whenDiapasonFrom50To70() {
        List<Student> students = List.of(new Student(50),
                new Student(10),
                new Student(90),
                new Student(60),
                new Student(70)
        );
        School school = new School();
        List<Student> rsl = school.collect(students,
                student -> student.getScore() >= 50 && student.getScore() < 70);
        assertThat(rsl, containsInAnyOrder(new Student(50), new Student(60)));
    }

    @Test
    public void whenDiapasonFrom0To50() {
        List<Student> students = List.of(new Student(50),
                new Student(60),
                new Student(10),
                new Student(90),
                new Student(30)
        );
        List<Student> rsl = new School().collect(students,
                student -> student.getScore() >= 0 && student.getScore() < 50);
        assertThat(rsl, containsInAnyOrder(new Student(30), new Student(10)));
    }
}
