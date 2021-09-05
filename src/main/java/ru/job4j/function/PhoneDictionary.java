package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Evgenii Shegai
 * @since 05.09.2021
 * @version 1.0
 */

public class PhoneDictionary {

    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> one = x -> x.getName().equals(key);
        Predicate<Person> two = x -> x.getSurname().equals(key);
        Predicate<Person> three = x -> x.getAddress().equals(key);
        Predicate<Person> four = x -> x.getPhone().equals(key);
        Predicate<Person> combine = one.or(two.or(three.or(four)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
