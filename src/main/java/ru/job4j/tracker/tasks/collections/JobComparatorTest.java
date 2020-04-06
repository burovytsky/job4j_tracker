package ru.job4j.tracker.tasks.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobComparatorTest {
    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Im pl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        List<Job> items = new ArrayList<>();
        items.add(new Job("Do2", 2));
        items.add(new Job("Do1", 5));
        items.add(new Job("Do4", 6));
        items.add(new Job("Do4", 3));
        items.add(new Job("Do4", 1));
        List<Job> itemsSorted = Arrays.asList(
                new Job("Do1", 5),
                new Job("Do2", 2),
                new Job("Do4", 1),
                new Job("Do4", 3),
                new Job("Do4", 6));
        items.sort(cmpNamePriority);
        assertEquals(items, itemsSorted);
    }

    @Test
    public void whenComparatorAscByName() {
        List<Job> items = new ArrayList<>();
        items.add(new Job("Do2", 2));
        items.add(new Job("Do1", 5));
        items.add(new Job("Do4", 6));
        items.add(new Job("Do3", 3));
        List<Job> itemsSorted = Arrays.asList(
                new Job("Do1", 5),
                new Job("Do2", 2),
                new Job("Do3", 3),
                new Job("Do4", 6));
        items.sort(new JobAscByName());
        assertEquals(items, itemsSorted);
    }

    @Test
    public void whenComparatorDescByName() {
        List<Job> items = new ArrayList<>();
        items.add(new Job("Do2", 2));
        items.add(new Job("Do1", 5));
        items.add(new Job("Do4", 6));
        items.add(new Job("Do3", 3));
        List<Job> itemsSorted = Arrays.asList(
                new Job("Do4", 6),
                new Job("Do3", 3),
                new Job("Do2", 2),
                new Job("Do1", 5));
        items.sort(new JobDescByName());
        assertEquals(items, itemsSorted);
    }

    @Test
    public void whenComparatorAscByPriority() {
        List<Job> items = new ArrayList<>();
        items.add(new Job("Do2", 2));
        items.add(new Job("Do1", 5));
        items.add(new Job("Do4", 6));
        items.add(new Job("Do3", 3));
        List<Job> itemsSorted = Arrays.asList(
                new Job("Do2", 2),
                new Job("Do3", 3),
                new Job("Do1", 5),
                new Job("Do4", 6));
        items.sort(new JobAscByPriority());
        assertEquals(items, itemsSorted);
    }

    @Test
    public void whenComparatorDescByPriority() {
        List<Job> items = new ArrayList<>();
        items.add(new Job("Do2", 2));
        items.add(new Job("Do1", 5));
        items.add(new Job("Do4", 6));
        items.add(new Job("Do3", 3));
        List<Job> itemsSorted = Arrays.asList(
                new Job("Do4", 6),
                new Job("Do1", 5),
                new Job("Do3", 3),
                new Job("Do2", 2));
        items.sort(new JobDescByPriority());
        System.out.println(itemsSorted);
        assertEquals(items, itemsSorted);
    }
}