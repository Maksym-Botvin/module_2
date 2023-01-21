package com.botvin.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer {

    private String id;
    private String email;
    private int age;

    public Customer() {

    }

    public Customer(String id, String email, int age) {
        this.id = id;
        this.email = email;
        this.age = age;
    }
    @Override
    public String toString() {
        return "id: " + id + ", email: " + email + ", age: " + age;
    }
}