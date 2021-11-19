package com.myapplication.Model;

public class Person {
    private String document;
    private String name;
    private int age;
    private String email;
    private String telephone;

    public Person() {
    }

    public Person(String document, String name, int age, String email, String telephone) {
        this.document = document;
        this.name = name;
        this.age = age;
        this.email = email;
        this.telephone = telephone;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
