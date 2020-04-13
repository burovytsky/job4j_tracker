package ru.job4j.tracker.tasks.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> searchByName = person -> person.getName().contains(key);
        Predicate<Person> searchBySurname = person -> person.getSurname().contains(key);
        Predicate<Person> searchByPhone = person -> person.getPhone().contains(key);
        Predicate<Person> searchByAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = searchByName.or(searchBySurname).or(searchByPhone).or(searchByAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
