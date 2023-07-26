package com.company.HighQualityStructureExam01.entities;

public abstract class BasePlayer implements Player {
    private String name;
    private String nationality;
    private double kg;
    private int strength;

    protected BasePlayer(String name, String nationality, int strength) {
        setName(name);
        setNationality(nationality);
        setStrength(strength);
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    public void setNationality(String nationality) {
        if (nationality == null || nationality.equals(" ")) {
            throw new NullPointerException(PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }
        this.nationality = nationality;
    }

    public void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException(PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.equals(" ")) {
            throw new NullPointerException(PLAYER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void stimulation() {

    }

    @Override
    public double getKg() {
        return this.kg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }
}

