package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {

    private final List<Item> items = new ArrayList<>();

    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> itemsMatchingByName = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsMatchingByName.add(item);
            }
        }
        return itemsMatchingByName;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item findById(String id) {
        Item rsl = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                rsl = item;
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        int index = indexOfElement(id);
        boolean rsl = false;
        if (index != -1) {
            item.setId(items.get(index).getId());
            items.set(index, item);
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(String id) {
        int index = indexOfElement(id);
        boolean rsl = false;
        if (index != -1) {
            items.remove(index);
            rsl = true;
        }
        return rsl;
    }

    private int indexOfElement(String id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                rsl = items.indexOf(item);
            }
        }
        return rsl;
    }
}