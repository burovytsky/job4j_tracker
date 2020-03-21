package ru.job4j.tracker.oop;

public class Tiger extends Predator {
    public Tiger() {
        super();
        System.out.println("конструктор Tiger без параметров");
    }

    public Tiger(String name) {
        super(name);
        System.out.println("конструтор Tiger с параметром name");
    }
}
