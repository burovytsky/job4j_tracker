package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.tasks.lambda.School;
import ru.job4j.tracker.tasks.lambda.Student;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


public class SchoolTest {

    @Test
    public void levelOfTest() {
        List<Student> students = List.of(
                new Student("Vasya", 50),
                new Student("Petr", 90),
                new Student("Julia", 30),
                new Student("Dan", 100),
                new Student("Juri", 10));
        List<Student> expected = List.of(
                new Student("Dan", 100),
                new Student("Petr", 90));
        List<Student> rsl = new School().levelOf(students, 50);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenConvertedListToMap() {
        List<Student> students = List.of(
                new Student("Ivan", 50),
                new Student("Vasya", 80),
                new Student("Petr", 90),
                new Student("Juri", 30)
        );
        Map<String, Student> rsl = new School().convertedToMap(students);
        for (Map.Entry<String, Student> studentMap : rsl.entrySet()) {
            System.out.println(studentMap.getKey() + " " + studentMap.getValue().toString());
        }
        assertThat(rsl, hasEntry("Petr", new Student("Petr", 90)));
    }

    @Test
    public void whenDiapasonFrom70To100() {
        List<Student> students = List.of(
                new Student("Ivan", 50),
                new Student("Vasya", 80),
                new Student("Petr", 90),
                new Student("Juri", 30)
        );
        List<Student> rsl = new School().collect(students,
                student -> student.getScore() >= 70 && student.getScore() <= 100);
        assertThat(rsl, containsInAnyOrder(new Student("Vasya", 80), new Student("Petr", 90)));
    }

    @Test
    public void whenDiapasonFrom50To70() {
        List<Student> students = List.of(new Student("Igor", 50),
                new Student("Ivan", 10),
                new Student("Vasya", 90),
                new Student("Petr", 60),
                new Student("Juri", 70)
        );
        School school = new School();
        List<Student> rsl = school.collect(students,
                student -> student.getScore() >= 50 && student.getScore() < 70);
        assertThat(rsl, containsInAnyOrder(new Student("Igor", 50), new Student("Petr", 60)));
    }

    @Test
    public void whenDiapasonFrom0To50() {
        List<Student> students = List.of(
                new Student("Ivan", 50),
                new Student("Vasya", 60),
                new Student("Petr", 10),
                new Student("Juri", 90),
                new Student("Igor", 30)
        );
        List<Student> rsl = new School().collect(students,
                student -> student.getScore() >= 0 && student.getScore() < 50);
        assertThat(rsl, containsInAnyOrder(new Student("Igor", 30), new Student("Petr", 10)));
    }
}
