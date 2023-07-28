package com.company.HighQualityStructureExam01.entities.field;

import com.company.HighQualityStructureExam01.entities.player.Player;

import java.util.stream.Collectors;

public class ArtificialTurf extends BaseField {
    private static final int INITIAL_CAPACITY = 150;

    public ArtificialTurf(String name) {
        super(name, INITIAL_CAPACITY);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (ArtificialTurf):", this.getName()));
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
    //"{fieldName} ({fieldType}):
    //Player: {playerName1} {playerName2} {playerName3} (…) / Player: none
    //Supplement: {supplementsCount}
    //Energy: {sumEnergy}"
}
