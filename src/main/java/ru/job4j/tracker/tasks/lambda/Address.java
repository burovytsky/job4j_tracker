package ru.job4j.tracker.tasks.lambda;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return home == address.home
                && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, home);
    }

    public String getCity() {
        return city;
    }

    public int getHome() {
        return home;
    }

    public Address(String city, int home) {
        this.city = city;
        this.home = home;
    }
}
