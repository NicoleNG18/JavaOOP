package com.company.HighQualityStructureExam01;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private SupplementRepository supplement;
    private Map<String, Field> fields;

    public ControllerImpl() {
        supplement = new SupplementRepositoryImpl();
        fields = new LinkedHashMap<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        if (fieldType.equals("ArtificialTurf")) {
            this.fields.put(fieldName, new ArtificialTurf(fieldName));
        } else if (fieldType.equals("NaturalGrass")) {
            this.fields.put(fieldName, new NaturalGrass(fieldName));
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        if (type.equals("Powdered")) {
            this.supplement.add(new Powdered());
        } else if (type.equals("Liquid")) {
            this.supplement.add(new Liquid());
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        if (this.supplement.findByType(supplementType) == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        Supplement supplement = supplementType.equals("Powdered")
                ? new Powdered()
                : new Liquid();
        this.supplement.remove(supplement);
        Field field = fields.values().stream().filter(e -> e.getName().equals(fieldName)).findFirst().orElse(null);
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        assert field != null;
        field.addSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        String output;
        Field field = fields.values().stream().filter(e -> e.getName().equals(fieldName)).findFirst().orElse(null);
        assert field != null;
        if (!playerType.equals("Men") && !playerType.equals("Women")) {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        Player player = playerType.equals("Men")
                ? new Men(playerName, nationality, strength)
                : new Women(playerName, nationality, strength);

        if (playerType.equals("Men") && field.getClass().getSimpleName().equals("NaturalGrass")) {
            field.addPlayer(player);
            output = String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
        } else if (playerType.equals("Women") && field.getClass().getSimpleName().equals("ArtificialTurf")) {
            field.addPlayer(player);
            output = String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
        } else {
            output = FIELD_NOT_SUITABLE;
        }
        return output;
    }


    @Override
    public String dragPlayer(String fieldName) {
        Field field = fields.values().stream().filter(e -> e.getName().equals(fieldName)).findFirst().orElse(null);
        assert field != null;
        field.drag();
        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = fields.values().stream().filter(e -> e.getName().equals(fieldName)).findFirst().orElse(null);
        assert field != null;
        int sumStr = field.getPlayers().stream().mapToInt(Player::getStrength).sum();
        return String.format(STRENGTH_FIELD, fieldName, sumStr);
    }

    @Override
    public String getStatistics() {
        return fields.values().stream().map(Field::getInfo).collect(Collectors.joining(System.lineSeparator()));
    }
}

