package com.find.old.user;

import java.time.LocalDate;
import java.time.Period;

public class User {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int number;
    private Period age;


    public User(String firstName, String lastName, LocalDate dateOfBirth, int number, Period age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.number = number;

        this.age = age ;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumber() {
        return number;
    }
    public Period getAge() {
        return age;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAge(Period age) {
        this.age = age;
    }
}
