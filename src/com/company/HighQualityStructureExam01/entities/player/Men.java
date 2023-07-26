package com.company.HighQualityStructureExam01.entities.player;

public class Men extends BasePlayer {
    private static double INITIAL_KILOGRAMS = 85.50;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, strength);
    }

    @Override
    public void stimulation() {
        setStrength(this.getStrength() + 145);
    }
}

