package ru.job4j.tracker.tasks.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> usersAccounts = users.get(user);
        if (user != null) {
            if (!usersAccounts.contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        return users.entrySet().stream().filter(userListEntry -> userListEntry.getKey().getPassport().equals(passport))
                .findFirst().map(Map.Entry::getKey).orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        Account desiredAccount = null;
        User user = findByPassport(passport);
        List<Account> usersAccounts = users.get(user);
        if (usersAccounts != null) {
            desiredAccount = usersAccounts.stream().filter(account -> account.getRequisite().equals(requisite))
                    .findFirst().orElse(null);
        }
        return desiredAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
