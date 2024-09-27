package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    private boolean nextRound() {
        long guess = player.askNextGuess();
        if (guess == numberToGuess) {
            logger.log("win end fini done le nombre est:" + numberToGuess);
            return true;
        } else {
            player.respond(guess < numberToGuess);
        }
        return false;
    }

    public void loopUntilPlayerSucceed(long maxIterations) {
        long startTime = System.currentTimeMillis();
        boolean success = false;

        for (long i = 0; i < maxIterations; i++) {
            success = nextRound();
            if (success) {
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        logger.log("Temps écoulé: " + (duration / 1000) + " secondes.");

        if (success) {
            logger.log("c'est gagné !");
        } else {
            logger.log("c'est perdu !");
        }
    }
}