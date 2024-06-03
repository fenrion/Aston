package org.example;

import java.util.Comparator;

/**
 * Comparator for Person.class
 */

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}
