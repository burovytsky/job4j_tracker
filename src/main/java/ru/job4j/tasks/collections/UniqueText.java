package ru.job4j.tasks.collections;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String originWords : origin) {
            check.add(originWords);
        }
        for (String duplicateWords : text) {
            if (!check.contains(duplicateWords)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
