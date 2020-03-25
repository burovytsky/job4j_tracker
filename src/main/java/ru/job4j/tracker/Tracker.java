package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {

    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    public Item[] findByName(String key) {
        Item[] itemsMatchingByName = new Item[position];
        int size = 0;
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                itemsMatchingByName[size] = items[i];
                size++;
            }
        }
        itemsMatchingByName = Arrays.copyOf(itemsMatchingByName, size);
        return itemsMatchingByName;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public void replace(String id, Item item) {
        int index = indexOf(id);
        item.setId(items[index].getId());
        items[index] = item;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public void delete(String id) {
        int index = indexOf(id);
        int size = position - index;
        System.arraycopy(items, index + 1, items, index, size);
        items[position - 1] = null;
        position--;
    }
}