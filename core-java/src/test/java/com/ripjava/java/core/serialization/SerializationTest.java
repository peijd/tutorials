package com.ripjava.java.core.serialization;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SerializationTest {

    @Test
    public void test_SerializingAndDeserializing()
            throws Exception {
        Person person = new Person();
        person.setAge(20);
        person.setName("Joe");

        FileOutputStream fileOutputStream
                = new FileOutputStream("serialization.txt");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream("serialization.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        Person p2 = (Person) objectInputStream.readObject();
        objectInputStream.close();

        assertTrue(p2.getAge() == person.getAge());
        assertTrue(p2.getName().equals(person.getName()));
    }

    @Test
    public void test_CustomSerializingAndDeserializing()
            throws IOException, ClassNotFoundException {
        Person p = new Person();
        p.setAge(20);
        p.setName("Joe");

        Address a = new Address();
        a.setHouseNumber(1);

        Employee e = new Employee();
        e.setPerson(p);
        e.setAddress(a);

        FileOutputStream fileOutputStream
                = new FileOutputStream("serialization2.txt");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(e);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream("serialization2.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        Employee e2 = (Employee) objectInputStream.readObject();
        objectInputStream.close();

        assertTrue(
                e2.getPerson().getAge() == e.getPerson().getAge());
        assertTrue(
                e2.getAddress().getHouseNumber() == e.getAddress().getHouseNumber());
    }

}
