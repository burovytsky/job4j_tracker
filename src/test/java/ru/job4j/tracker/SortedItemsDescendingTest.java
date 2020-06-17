package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tasks.SortItemsDescending;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortedItemsDescendingTest {
    @Test
    public void sort() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Ivan"));
        items.add(new Item("Petr"));
        items.add(new Item("Dima"));
        items.add(new Item("Vasya"));
        items.add(new Item("Dan"));
        List<Item> itemsSorted = Arrays.asList(
                new Item("Vasya"),
                new Item("Petr"),
                new Item("Ivan"),
                new Item("Dima"),
                new Item("Dan"));
        items.sort(new SortItemsDescending());
        assertThat(items, is(itemsSorted));
    }

}

