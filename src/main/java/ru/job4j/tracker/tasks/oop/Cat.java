package ru.job4j.tracker.tasks.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.println(this.name + ", " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's name and food.");
        Cat gav = new Cat();
        gav.giveNick("Jack");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's name and food.");
        Cat black = new Cat();
        black.giveNick("Tom");
        black.eat("fish");
        black.show();
    }
}
