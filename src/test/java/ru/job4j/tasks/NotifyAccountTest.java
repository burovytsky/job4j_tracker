package ru.job4j.tasks;
import org.junit.Test;
import ru.job4j.tasks.collections.Account;
import ru.job4j.tasks.collections.NotifyAccount;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
    @Test
    public void areDuplicateItemsDeleted() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("123", "Petr Arsentev", "23423433"),
                new Account("142", "Ivan Ivanov", "00231"),
                new Account("141", "Igor Petrov", "23412"),
                new Account("142", "Petr Arsentev", "023231")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001"),
                        new Account("141", "Igor Petrov", "23412")
                        )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}
