package model;

import java.util.concurrent.ThreadLocalRandom;

public class Person {

    private String name;
    private String surname;
    private int age;

    public Person(String name, String surename, int age) {
        this.name = name;
        this.surname = surename;
        this.age = age;
    }

    public Person(String name, String surename) {
        this.name = name;
        this.surname = surename;
        this.age = RandomAge();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getInfo() {
        return surname + ", " + name + " (" + age + ")";
    }

    public static Person fromCsv(String csv) {
        String[] split = csv.split("\t");
        Person person = new Person(split[0], split[1], Integer.valueOf(split[2]));
        return person;
    }

    public static int RandomAge() {
        return ThreadLocalRandom.current().nextInt(19, 83);
    }

}
