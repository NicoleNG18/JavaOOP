package com.company.HighQualityStructureExam01.entities.field;

import java.util.stream.Collectors;

public class NaturalGrass extends BaseField{
    private static final int INITIAL_CAPACITY=250;

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (NaturalGrass):", this.getName()));
        sb.append(System.lineSeparator());
        sb.append("Player: ");
        if(this.getPlayers().size()==0){
            sb.append("none");

        } else{
            sb.append(this.getPlayers().stream().map(Player::getName).collect(Collectors.joining(" ")));
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("Supplement: %d",this.getSupplement().size()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Energy: %d",this.sumEnergy()));
        return sb.toString();

    }
    public NaturalGrass(String name) {
        super(name, INITIAL_CAPACITY);
    }
}

