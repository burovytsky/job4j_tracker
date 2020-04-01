package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.tasks.ex.Fact;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenNIsLessThanZero() {
        Fact.calc(-5);
    }
}
