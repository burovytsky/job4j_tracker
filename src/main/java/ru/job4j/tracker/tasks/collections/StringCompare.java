package ru.job4j.tracker.tasks.collections;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = Integer.compare(left.length(), right.length());
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            int charCompareRsl = Character.compare(left.charAt(i), right.charAt(i));
            if (charCompareRsl != 0) {
                rsl = charCompareRsl;
                break;
            }
        }
        return rsl;
    }
}