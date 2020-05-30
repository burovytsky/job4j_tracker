package ru.job4j.tasks;

import org.junit.Test;
import ru.job4j.tasks.ex.Fact;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenNIsLessThanZero() {
        Fact.calc(-5);
    }
}
