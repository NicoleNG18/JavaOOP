package com.company.inheritance.Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null|| name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>0) {
            this.age = age;
        }
        else{
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender==null || gender.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");

        }
        this.gender = gender;
    }

    public String produceSound(){
        return "";
    }

    @Override
    public String toString(){
        return String.format("%s%n%s %d %s%n%s",this.getClass().getSimpleName(),name,age,gender,produceSound());
    }
}
