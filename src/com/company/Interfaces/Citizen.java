package com.company.Interfaces;

public class Citizen implements Birthable,Identifiable{
    private String name;
    private int age;
    private String id;
    private String birthDate;

    protected Citizen(String name, int age, String id, String birthDate) {
        setName(name);
        setAge(age);
        setId(id);
        setBirthDate(birthDate);
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate=birthDate;
    }
}

