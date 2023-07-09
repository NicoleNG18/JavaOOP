package com.company.reflectionAndAnnotation.barakWars.core;

public class Engine implements Runnable {

    private CommandInterpreter commandInterpreter;

    public Engine(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }

    public Engine(CommandInterpreter commandInterpreter) {
    }

    public Engine(CommandInterpreter commandInterpreter) {
    }

    @Override
    public void run() {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.ReadLine();

                String[] data = input.split("\\s+");

                final Executable executable = this.commandInterpreter.interpretCommand(data);

                String result = executable.execute();

                if (result.equals("fight")) {
                    break;
                }

                System.out.println(result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}



