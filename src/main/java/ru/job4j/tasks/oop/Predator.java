package ru.job4j.tasks.oop;

public class Predator extends Animal {
    public Predator() {
        super();
        System.out.println("конструктор Predator без параметров");
    }

    public Predator(String name) {
        super(name);
        System.out.println("конструтор Predator с параметром name");
    }
}
