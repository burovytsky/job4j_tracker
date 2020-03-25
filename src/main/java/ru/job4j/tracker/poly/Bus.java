package ru.job4j.tracker.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int numberOfPassengers) {
        System.out.println("Количество пассажиров : " + numberOfPassengers);
    }

    @Override
    public double refuel(double fuel) {
        return fuel * 70;
    }
}
