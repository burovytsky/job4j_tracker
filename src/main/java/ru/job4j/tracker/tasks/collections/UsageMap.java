package ru.job4j.tracker.tasks.collections;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> accounts = new HashMap<>();
        accounts.put("ivan_ivanov@gmai.com", "Ivan Ivanov");
        accounts.put("burovytsky@gmai.com", "Constantine Burovytsky");
        accounts.put("petrov@gmai.com", "Daniel Petrov");

        for (String key : accounts.keySet()) {
            String value = accounts.get(key);
            System.out.println("Name: " + value + ". Email : " + key);
        }
    }
}
