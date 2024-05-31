package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort() {
        Person person1 = new Person("name1", 6);
        Person person2 = new Person("name2",5);
        Person person3 = new Person("name3", 1);
        Person person4 = new Person("name4",3);
        Person person5 = new Person("name5",8);
        Person person6 = new Person("name6",4);
        Person person7 = new Person("name7",7);
        Person person8 = new Person("name8",9);
        Person person9 = new Person("name9",2);
        MKArrayList<Person> mkArrayList = new MKArrayList<>();
        mkArrayList.add(person1);
        mkArrayList.add(person2);
        mkArrayList.add(person3);
        mkArrayList.add(person4);
        mkArrayList.add(person5);
        mkArrayList.add(person6);
        mkArrayList.add(person7);
        mkArrayList.add(person8);
        mkArrayList.add(person9);
        QuickSort<Person> quickSort = new QuickSort<>();
        quickSort.sort(Comparator.comparingInt(Person::getAge),mkArrayList);

        Assertions.assertEquals(person6,mkArrayList.get(3));
        Assertions.assertEquals(person3,mkArrayList.get(0));
        Assertions.assertEquals(person8,mkArrayList.get(8));
    }
}