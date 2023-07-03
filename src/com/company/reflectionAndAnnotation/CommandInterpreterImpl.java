package com.company.reflectionAndAnnotation;

import java.lang.reflect.Field;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMAND_PACKAGE = "barracksWars.core.commands.";

    private final Repository repository;

    private final UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    @SuppressWarnings("all")
    public Executable interpretCommand(String data[]) {
        final String commName = Character.toUpperCase(data[0].charAt(0)) + data[0].substring(1);
        Executable executable = null;

        try {
            final Class<? extends Executable> commandClass = (Class<? extends Executable>)
                    Class.forName(CommandInterpreterImpl.COMMAND_PACKAGE + commName);

            final Constructor<? extends Executable> constructor = commandClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);

            executable = constructor.newInstance(new Object[]{data});

            final Field[] executableFields = executable.getClass().getDeclaredFields();

            final Field[] thisCommandImpl = this.getClass().getDeclaredFields();

            for (Field executableField : executableFields) {
                if (executableField.isAnnotationPresent(Inject.class)) {
                    for (Field field : thisCommandImpl) {
                        if (executableField.getType().equals(field.getType())) {
                            executableField.setAccessible(true);
                            executableField.set(executable, field.get(this));
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return executable;

    }
}

