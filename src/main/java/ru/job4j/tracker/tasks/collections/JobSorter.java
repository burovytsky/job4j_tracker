package ru.job4j.tracker.tasks.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Fix bugs", 2),
                new Job("Fix bugs", 3),
                new Job("Reboot server", 0)
        );
    }
}
