package ru.job4j.tracker.tasks.strategy;

import java.util.StringJoiner;

public class Square implements Shape {
    @Override
    public String draw() {
        StringJoiner pic = new StringJoiner(System.lineSeparator())
                .add("+++++++")
                .add("+     +")
                .add("+     +")
                .add("+++++++")
                .add(System.lineSeparator());
        return pic.toString();
    }
}
