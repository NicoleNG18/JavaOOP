package com.company.encapsulation.FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new LinkedHashMap<>();
        String commands = scanner.nextLine();

        while (!commands.equals("END")) {

            try {

                String[] help = commands.split(";");
                String command = help[0];
                String teamName=help[1];

                switch (command) {
                    case "Team" -> teams.putIfAbsent(teamName, new Team(teamName));
                    case "Add" -> addPlayer(teams, help, teamName);
                    case "Remove" -> removePlayer(teams, help, teamName);
                    case "Rating" -> calculateTeamRating(teams, teamName);
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            commands = scanner.nextLine();
        }
    }

    private static void calculateTeamRating(Map<String, Team> teams, String teamName) {

        if (teams.containsKey(teamName)) {
            System.out.printf("%s - %d%n", teamName, Math.round(teams.get(teamName).getRating()));
        } else {
            System.out.printf("Team %s does not exist.%n", teamName);
        }

    }

    private static void removePlayer(Map<String, Team> teams, String[] help, String teamName) {

        String playerName= help[2];

        if (teams.containsKey(teamName)){
            teams.get(teamName).removePlayer(playerName);
        } else {
            System.out.printf("Team %s does not exist.%n", teamName);
        }

    }

    private static void addPlayer(Map<String, Team> teams, String[] help, String teamName) {

        String playerName= help[2];
        int endurance=Integer.parseInt(help[3]);
        int sprint=Integer.parseInt(help[4]);
        int dribble=Integer.parseInt(help[5]);
        int passing=Integer.parseInt(help[6]);
        int shooting=Integer.parseInt(help[7]);

        if (teams.containsKey(teamName)) {
            Player player=new Player(playerName,endurance,sprint,dribble,passing,shooting);
            teams.get(teamName).addPlayer(player);
        } else {
            System.out.printf("Team %s does not exist.%n", teamName);
        }
    }
}

