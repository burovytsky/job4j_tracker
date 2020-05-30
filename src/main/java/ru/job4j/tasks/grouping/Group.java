package ru.job4j.tasks.grouping;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getUnits().stream().map(e -> new Holder(e, student.getName())))
                .collect(Collectors.groupingBy(holder -> holder.key,
                        Collector.of(HashSet::new, (set, el) -> set.add(el.value), (left, right) -> {
                            left.addAll(right);
                            return left;
                        })
                        )
                );
    }
}
