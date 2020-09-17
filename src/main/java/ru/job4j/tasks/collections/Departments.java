package ru.job4j.tasks.collections;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        TreeSet<String> rsl = new TreeSet<>();
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
        orgs.sort(new DepDescComp());
    }
}