package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.tasks.lambda.Address;
import ru.job4j.tracker.tasks.lambda.Profile;
import ru.job4j.tracker.tasks.lambda.Profiles;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void whenDiapasonFrom70To100() {
        List<Profile> profiles = Arrays.asList(
                new Profile(new Address("Kiev", 34)),
                new Profile(new Address("Moscow", 10)));
        List<Address> addressList = new Profiles().collect(profiles);
        assertThat(addressList, containsInAnyOrder(
                new Address("Kiev", 34),
                new Address("Moscow", 10)));
    }

    @Test
    public void whenSortedAndDeletedDuplicates() {
        List<Profile> profiles = Arrays.asList(
                new Profile(new Address("Kiev", 34)),
                new Profile(new Address("Lvov", 14)),
                new Profile(new Address("Lvov", 14)),
                new Profile(new Address("Lvov", 3)),
                new Profile(new Address("Kiev", 34)),
                new Profile(new Address("Kiev", 34)),
                new Profile(new Address("Odessa", 3)),
                new Profile(new Address("Moscow", 10)));
        List<Address> rsl = new Profiles().collect(profiles);
        List<Address> expected = Arrays.asList(
                new Address("Kiev", 34),
                new Address("Lvov", 14),
                new Address("Lvov", 3),
                new Address("Moscow", 10),
                new Address("Odessa", 3));
        assertThat(rsl, is(expected));
    }
}
