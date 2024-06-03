package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.commons.util.StringUtils;


class MKArrayListTest {
    private MKArrayList<String> testStringList;


    @BeforeEach
    void setUp() {
        testStringList = new MKArrayList<>();
    }

    @AfterEach
    void tearDown() {
        testStringList = null;
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3; '[4, 2, 3]'; '4,2,3'",
            "4; '[7, 3, 2, 1]'; '7,3,2,1'"
    }, delimiter = ';'
    )
    void testAdd(int expectedSize, String expectedToString, String values) {
        for (String value : values.split(",")) {
            testStringList.add(value);
        }
        Assertions.assertEquals(expectedSize, testStringList.getSize());
        Assertions.assertEquals(expectedToString, testStringList.toString());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4; '[5, 1, 2, 3]';    0; 5; '1,2,3'", // at start
            "4; '[1, 2, 7, 3]';    2; 7; '1,2,3'", // into middle
            "5; '[4, 3, 2, 1, 5]'; 4; 5; '4,3,2,1'" // into end
    }, delimiter = ';'
    )
    void addByIndex(int expectedSize, String expectedToString, int index, String elem, String values) {
        for (String value : values.split(",")) {
            testStringList.add(value);
        }
        testStringList.add(elem, index);

        Assertions.assertEquals(expectedSize, testStringList.getSize());
        Assertions.assertEquals(expectedToString, testStringList.toString());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4; '[0, 1, 2, 3]'; 2; '2,3'; '0,1'"
    }, delimiter = ';')
    void addArray(int expectedSize, String expectedToString,int addArrayLength, String addArray, String values){
        for (String value : values.split(",")) {
            testStringList.add(value);
        }
        String[] addArr = new String[addArrayLength];
        int i=0;
        for (String arr : addArray.split(",")) {
            addArr[i] = arr;
            i++;
        }
        testStringList.add(addArr);
        Assertions.assertEquals(expectedSize, testStringList.getSize());
        Assertions.assertEquals(expectedToString, testStringList.toString());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3; '[-1, 2, 3]'; 0; -1; '1,2,3'",
            "4; '[4, 3, -1, 1]'; 2; -1; '4,3,2,1'"
    }, delimiter = ';'
    )
    void set(int expectedSize, String expectedToString, int index, String elem, String values) {
        for (String value : values.split(",")) {
            testStringList.add(value);
        }
        testStringList.set(elem,index);

        Assertions.assertEquals(expectedSize, testStringList.getSize());
        Assertions.assertEquals(expectedToString, testStringList.toString());
    }


    @ParameterizedTest
    @CsvSource(value = {
            "2; '[1, 3]'; 1; '1,2,3'",
            "3; '[4, 2, 1]'; 1; '4,3,2,1'"
    }, delimiter = ';'
    )
    void remove(int expectedSize, String expectedToString, int index, String values) {
        for (String value : values.split(",")) {
            testStringList.add(value);
        }
        testStringList.remove(index);

        Assertions.assertEquals(expectedSize, testStringList.getSize());
        Assertions.assertEquals(expectedToString, testStringList.toString());
    }

    @Test
    void clear() {
        Person person = new Person("name", 10);
        Person person2 = new Person("name2",20);
        Person person3 = new Person("name3", 30);
        MKArrayList<Person> mkArrayList = new MKArrayList<>();
        mkArrayList.add(person);
        mkArrayList.add(person2);
        mkArrayList.add(person3);
        mkArrayList.clear();
        Assertions.assertEquals(0,mkArrayList.getSize());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0; 1; '1,2,3'",
            "2; 2; '4,3,2,1'",
            "3; 4; '1,2,3,4'"
    }, delimiter = ';'
    )
    void get(int index, String expectedValue, String values) {
        for (String value : values.split(",")) {
            testStringList.add(value);
        }
        for (int i = 0; i < 3; i++) {
            String elem = testStringList.get(index);
            Assertions.assertEquals(expectedValue, elem);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0; 0; ''",
            "2; 0; '1,2'",
            "4; 0; '4,3,2,1'"
    }, delimiter = ';'
    )
    void clear(int expectedSizeBefore, int expectedSizeAfter, String values) {
        for (int i = 0; i < 2; i++) {
            if (StringUtils.isNotBlank(values)) {
                for (String value : values.split(",")) {
                    testStringList.add(value);
                }
            }
            Assertions.assertEquals(expectedSizeBefore, testStringList.getSize());
            testStringList.clear();
            Assertions.assertEquals(expectedSizeAfter, testStringList.getSize());
        }
    }
}