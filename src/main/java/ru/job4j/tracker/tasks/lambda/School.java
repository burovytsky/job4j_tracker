package ru.job4j.tracker.tasks.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public Map<String, Student> convertedToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getSurname, student -> student));
    }

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().flatMap(Stream::ofNullable).sorted()
                .takeWhile(student -> student.getScore() > bound).collect(Collectors.toList());
    }
}
