package com.company.Interfaces.BirthdayCelebrations;

public class Pet implements Birthable{
    private String name;
    private String birthDate;

    protected Pet(String name, String birthDate) {
        setName(name);
        setBirthDate(birthDate);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

}
