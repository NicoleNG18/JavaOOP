package com.company.reflectionAndAnnotation.BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String END_COMMAND = "END";

    private static Map<String, Method> getMethods(Method[] methods) {
        return Arrays.stream(methods)
                .peek(e -> e.setAccessible(true))
                .collect(Collectors.toMap(Method::getName, method -> method));
    }

    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        Constructor<BlackBoxInt> ctor = BlackBoxInt.class.getDeclaredConstructor(int.class);
        ctor.setAccessible(true);

        Map<String, Method> methods1 = getMethods(BlackBoxInt.class.getDeclaredMethods());

        Object blackBoxObject = ctor.newInstance(0);

        while (!command.equals(END_COMMAND)) {

            String[] commandArray = command.split("_");
            String commandName = commandArray[0];
            int value = Integer.parseInt(commandArray[1]);

            methods1.get(commandName).invoke(blackBoxObject, value);

            Field field = BlackBoxInt.class.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBoxObject));

            command = scanner.nextLine();
        }

    }
}

