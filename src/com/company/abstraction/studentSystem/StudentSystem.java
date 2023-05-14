package com.company.abstraction.studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {

    private Map<String, Student> studentsByName;

    public StudentSystem() {
        this.studentsByName = new HashMap<>();
    }

    public void doCommands(String[] commands) {

        String mainCommand = commands[0];

        String name = commands[1];

        if (mainCommand.equals("Create")) {
            create(commands, name);
        } else if (mainCommand.equals("Show")) {
            show(name);
        } else {
            throw new IllegalArgumentException("Unknown command:" + mainCommand);
        }

    }

    private void show(String name) {
        Student student = studentsByName.get(name);

        if (student != null) {
            System.out.println(student.studentInfo());
        }

    }

    private void create(String[] commands, String name) {
        int age = Integer.parseInt(commands[2]);
        double grade = Double.parseDouble(commands[3]);

        studentsByName.putIfAbsent(name, new Student(name, age, grade));
    }


}

