package ru.job4j.tracker.tasks.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> rsl = new HashSet<>();
        for (String value : deps) {
            StringBuilder start = new StringBuilder();
            for (String el : value.split("/")) {
                rsl.add(start + el);
                start.append(el).append("/");
            }
        }
        return new ArrayList<>(rsl);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {

    }
}
