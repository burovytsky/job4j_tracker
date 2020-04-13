package ru.job4j.tracker.tasks.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Converter {
    public static void main(String[] args) {
        Integer[][] matrix = {{2, 4}, {5, 4}, {9, 3}, {8, 2}};

        List<Integer> list = Stream.of(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(list.toString());
    }
}
