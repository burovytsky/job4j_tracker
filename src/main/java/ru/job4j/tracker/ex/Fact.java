package ru.job4j.tracker.ex;

public class Fact {
    public static void main(String[] args) {
        Fact fact = new Fact();
        int rsl = fact.calc(-6);
        System.out.println(rsl);
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
