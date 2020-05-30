package ru.job4j.tasks.oop;

public class Animal {
    private String name;

    public Animal() {
        super();
        System.out.println("конструктор Animal без параметров");
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("конструтор Animal с параметром name");
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        System.out.println("вызов конструкторов с параметрами");
        Tiger tiger2 = new Tiger("Tigers name");
    }
}
