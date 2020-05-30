package ru.job4j.tasks;

import org.junit.Test;
import ru.job4j.tasks.grouping.Group;
import ru.job4j.tasks.grouping.Student;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;


public class GroupTest {

    @Test
    public void whenGroupedByInterests() {
        List<Student> students = List.of(
                new Student("Vasya", Set.of("Biology", "History",
                        "Psychology", "Football", "ComputerScience", "Physics")),
                new Student("Petr", Set.of("Physics", "History")),
                new Student("Julia", Set.of("Psychology", "Football", "ComputerScience")),
                new Student("Dan", Set.of("History", "ComputerScience", "Physics")),
                new Student("Juri", Set.of("Psychology", "Football", "Physics", "History")));
        List<String> expected1 = List.of("Julia", "Dan", "Vasya");
        List<String> expected2 = List.of("Vasya", "Petr", "Dan", "Juri");
        Map<String, Set<String>> rsl = Group.sections(students);
        assertTrue(rsl.get("ComputerScience").containsAll(expected1));
        assertTrue(rsl.get("History").containsAll(expected2));
    }
}
