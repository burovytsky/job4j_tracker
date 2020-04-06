package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortItemsAscendingTest {
    @Test
    public void sort() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Ivan"));
        items.add(new Item("Petr"));
        items.add(new Item("Dima"));
        items.add(new Item("Vasya"));
        items.add(new Item("Dan"));
        List<Item> itemsSorted = Arrays.asList(
                new Item("Dan"),
                new Item("Dima"),
                new Item("Ivan"),
                new Item("Petr"),
                new Item("Vasya"));
        items.sort(new SortItemsAscending());
        System.out.println(itemsSorted);
        assertEquals(items, itemsSorted);
    }

}
