package com.company.HighQualityStructureExam01.entities.player;

public class Women extends BasePlayer {
    private static double INITIAL_KILOGRAMS = 60.00;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, strength);
    }

    @Override
    public void stimulation() {
        setStrength(this.getStrength() + 115);
    }
}

