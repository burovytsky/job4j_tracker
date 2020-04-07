package ru.job4j.tracker;
import org.junit.Test;
import ru.job4j.tracker.tasks.collections.FullSearch;
import ru.job4j.tracker.tasks.collections.Task;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSearchTest {

    @Test
    public void extractNumber() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc"),
                new Task("3", "First desc"),
                new Task("3", "First desc")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2", "3"));
        assertThat(FullSearch.extractNumber(tasks), is(expected));
    }
}
