package ru.job4j.tasks;

import org.junit.Test;
import ru.job4j.tasks.collections.User;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>(
                Set.of(
                        new User("Petr", 32),
                        new User("Ivan", 31))
        );
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenAsc2() {
        Set<User> users = new TreeSet<>(
                Set.of(
                        new User("Petr", 32),
                        new User("Ivan", 31),
                        new User("Ivan", 23),
                        new User("Ivan", 3),
                        new User("Dmitry", 3),
                        new User("Stan", 3)
                )
        );
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Dmitry", 3)));
        assertThat(it.next(), is(new User("Ivan", 3)));
        assertThat(it.next(), is(new User("Ivan", 23)));
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
        assertThat(it.next(), is(new User("Stan", 3)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }
}