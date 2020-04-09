package ru.job4j.tracker.tasks.collections;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Array = o1.split("/");
        String[] o2Array = o2.split("/");
        int rsl = o2Array[0].compareTo(o1Array[0]);
        if (rsl == 0) {
            for (int i = 1; i < Math.min(o1Array.length, o2Array.length); i++) {
                rsl = o1Array[i].compareTo(o2Array[i]);
                break;
            }
        }
        if (rsl == 0) {
            rsl = o1.compareTo(o2);
        }
        return rsl;
    }
}
