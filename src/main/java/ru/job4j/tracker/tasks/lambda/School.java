package ru.job4j.tracker.tasks.lambda;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public Map<String, Student> convertedToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getSurname, student -> student));
    }
}
