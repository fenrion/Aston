package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class MKArrayListTest {

    @Test
    void add() {
        Person person = new Person("name", 10);
        MKArrayList<Person> mkArrayList = new MKArrayList<>();
        mkArrayList.add(person);
        Assertions.assertEquals(mkArrayList.getSize(),1);
    }

    @Test
    void testAdd() {
        Person person = new Person("name", 10);
        Person person2 = new Person("name2",20);
        Person person3 = new Person("name3", 30);
        Person person4 = new Person("name4",40);
        Person person5 = new Person("name5",50);
        Person person6 = new Person("name6",60);
        MKArrayList<Person> mkArrayList = new MKArrayList<>();
        mkArrayList.add(person);
        mkArrayList.add(person2);
        mkArrayList.add(person3);
        mkArrayList.add(person4,1);

        Assertions.assertEquals(mkArrayList.get(1),person4);
        Assertions.assertEquals(mkArrayList.get(2),person2);
        Assertions.assertThrows(IndexOutOfBoundsException.class,()->{mkArrayList.add(person5,-1);});
        Assertions.assertThrows(IndexOutOfBoundsException.class,()->{mkArrayList.add(person6,100);});
    }

    @Test
    void testAdd1() {
        Person[] arr = {
                new Person("name",10),
                new Person("name2",20)
        };
        Person person4 = new Person("name4",40);
        Person person5 = new Person("name5",50);
        Person person6 = new Person("name6",60);
        MKArrayList<Person> mkArrayList = new MKArrayList<>();
        mkArrayList.add(person4);
        mkArrayList.add(person5);
        mkArrayList.add(person6);
        mkArrayList.add(arr);
        Person person7= new Person("name2",20);
        Assertions.assertEquals(person7 ,mkArrayList.get(4));
    }

    @Test
    void remove() {
        Person person = new Person("name", 10);
        Person person2 = new Person("name2",20);
        Person person3 = new Person("name3", 30);
        MKArrayList<Person> mkArrayList = new MKArrayList<>();
        mkArrayList.add(person);
        mkArrayList.add(person2);
        mkArrayList.add(person3);
        mkArrayList.remove(1);

        Assertions.assertEquals(person3,mkArrayList.get(1));
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

    @Test
    void get() {
        Person person = new Person("name", 10);
        Person person2 = new Person("name",10);
        MKArrayList<Person> mkArrayList = new MKArrayList<>();
        mkArrayList.add(person);
        Assertions.assertEquals(mkArrayList.get(0),person2);
    }

    @Test
    void set() {
        Person person = new Person("name", 10);
        Person person2 = new Person("name2", 20);
        MKArrayList<Person> mkArrayList = new MKArrayList<>();
        mkArrayList.add(person);
        mkArrayList.set(person2,0);
        Assertions.assertEquals(person2,mkArrayList.get(0));
    }
}