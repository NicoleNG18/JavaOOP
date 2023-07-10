package com.company.reflectionAndAnnotation.lab;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        TreeSet<Field> fields = getSortedFields(clazz);
        checkFields(fields);

        TreeSet<Method> getters = collectByName( clazz,"get");
        checkGetters(getters);

        TreeSet<Method> setters = collectByName( clazz,"set");
        checkSetters(setters);

    }

    private static TreeSet<Field> getSortedFields(Class<Reflection> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(Field::getName))));
    }

    private static TreeSet<Method> collectByName(Class clazz,String get) {
        return Arrays.stream(clazz.getDeclaredMethods()).
                filter(e -> e.getName().contains(get))
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(Method::getName))));
    }

    private static void checkFields(TreeSet<Field> fields) {
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (!Modifier.isPrivate(modifiers)) {
                System.out.printf("%s must be private!%n", field.getName());
            }
        }
    }

    private static void checkSetters(TreeSet<Method> setters) {
        for (Method setter : setters) {
            int modifiers = setter.getModifiers();
            if (!Modifier.isPrivate(modifiers)) {
                System.out.printf("%s have to be private!%n",setter.getName());
            }
        }
    }

    private static void checkGetters(TreeSet<Method> getters) {
        for (Method getter : getters) {
            int modifiers = getter.getModifiers();
            if (!Modifier.isPublic(modifiers)) {
                System.out.printf("%s have to be public!%n",getter.getName());
            }
        }
    }
}

//        Function<Class<?>, String> formatOutput = c -> c == int.class ? "class int" : c.toString();
//
//        getters.forEach(e -> System.out.printf("%s will return %s%n",
//                e.getName(), formatOutput.apply(e.getReturnType())));
//
//        setters.forEach(e -> System.out.printf("%s and will set field of %s%n",
//                e.getName(), formatOutput.apply(e.getParameterTypes()[0])));
