package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Comparator;


class QuickSortTest {
    private MKArrayList<Person> testPersons;
    @BeforeEach
    void setUp() {
        testPersons = new MKArrayList<>();
    }


    @AfterEach
    void tearDown() {
        testPersons = null;
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5 10 30; name1 10,name2 30,name3 5"
    }, delimiter = ';'
    )
    void sortByComparator(String expectedToString,String values) {
        for (String value : values.split(",")) {
            String[] person = value.split(" ");
            testPersons.add(new Person(person[0],Integer.parseInt(person[1])));
        }
        QuickSort<Person> quickSort = new QuickSort<>();
        quickSort.sort(Comparator.comparingInt(Person::getAge),testPersons);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<testPersons.getSize();i++){
            sb.append(testPersons.get(i).getAge()).append(" ");
        }
        Assertions.assertEquals(expectedToString, sb.toString().trim());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5 10 30; name1 10,name2 30,name3 5"
    }, delimiter = ';'
    )
    void sortByComparable(String expectedToString,String values) {
        for (String value : values.split(",")) {
            String[] person = value.split(" ");
            testPersons.add(new Person(person[0],Integer.parseInt(person[1])));
        }
        QuickSort<Person> quickSort = new QuickSort<>();
        quickSort.sort(testPersons);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<testPersons.getSize();i++){
            sb.append(testPersons.get(i).getAge()).append(" ");
        }
        Assertions.assertEquals(expectedToString, sb.toString().trim());
    }

}