package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("-interactive")) {
            Player player = new HumanPlayer();
            Simulation simulation = new Simulation(player);
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        } else if (args.length > 1 && args[0].equals("-auto")) {
            long numberToGuess = Long.parseLong(args[1]);
            Player player = new ComputerPlayer();
            Simulation simulation = new Simulation(player);
            simulation.initialize(numberToGuess);
            simulation.loopUntilPlayerSucceed(1000);
        } else {
            System.out.println("Usage: -interactive ou -auto <nombre>");
        }
    }
}