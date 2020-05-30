package ru.job4j.tasks.poly;

public interface Transport {
    void go();

    void passengers(int numberOfPassengers);

    double refuel(double fuel);
}
