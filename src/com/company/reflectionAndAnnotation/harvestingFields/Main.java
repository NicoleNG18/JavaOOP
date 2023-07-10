package com.company.reflectionAndAnnotation.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final Field[] RICH_SOIL_LAND = RichSoilLand.class.getDeclaredFields();

    private static final String END_COMMAND = "HARVEST";

    private static final String PUBLIC = "public";

    private static final String PRIVATE = "private";

    private static final String PROTECTED = "protected";

    private static final Function<Field,String> FIELD_FORMAT=field -> String.format("%s %s %s",
            Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());

    public static void main(String[] args) {

        String command = SCANNER.nextLine();

        while (!command.equals(END_COMMAND)) {

            switch (command) {

                case PUBLIC:
                    printFilteredFields(PUBLIC);
                    break;

                case PRIVATE:
                    printFilteredFields(PRIVATE);
                    break;

                case PROTECTED:
                    printFilteredFields(PROTECTED);
                    break;

                default:
                    Arrays.stream(RICH_SOIL_LAND)
                            .map(FIELD_FORMAT)
                            .forEach(System.out::println);
                    break;

            }
            command = SCANNER.nextLine();
        }
        SCANNER.close();
    }

    private static void printFilteredFields(String command) {
        Arrays.stream(RICH_SOIL_LAND).
                filter(e -> Modifier.toString(e.getModifiers()).equals(command))
                .map(FIELD_FORMAT)
                .forEach(System.out::println);
    }
}

