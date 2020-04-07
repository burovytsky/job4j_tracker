package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.tasks.bank.Account;
import ru.job4j.tracker.tasks.bank.BankService;
import ru.job4j.tracker.tasks.bank.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertNull(bank.findByRequisite("34", "5546"));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.addAccount(user.getPassport(), new Account("4", 30D));
        bank.addAccount(user.getPassport(), new Account("5", 20D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 15D);
        bank.transferMoney(user.getPassport(), "113", user.getPassport(), "5", 10D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(), is(55D));
    }
}
