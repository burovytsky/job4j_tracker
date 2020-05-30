package ru.job4j.tasks;

import org.junit.Test;
import ru.job4j.tasks.collections.Citizen;
import ru.job4j.tasks.collections.PassportOffice;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }
}
