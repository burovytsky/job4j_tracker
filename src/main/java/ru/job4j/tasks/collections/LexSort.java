package ru.job4j.tasks.collections;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int firstNum = Integer.parseInt(o1.split(". ")[0]);
        int secondNum = Integer.parseInt(o2.split(". ")[0]);
        return Integer.compare(firstNum, secondNum);
    }
}
