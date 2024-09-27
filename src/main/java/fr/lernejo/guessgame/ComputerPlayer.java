package fr.lernejo.guessgame;

import java.util.Random;

public class ComputerPlayer implements Player {
    private long lowerBound = 0;
    private long upperBound = 100;

    @Override
    public long askNextGuess() {
        long lastGuess = (lowerBound + upperBound) / 2;
        System.out.println("Le robot propose : " + lastGuess);
        return lastGuess;
    }

    @Override
    public void respond(boolean isGuessLower) {
        if (isGuessLower) {
            lowerBound = (lowerBound + upperBound) / 2 + 1;
        } else {
            upperBound = (lowerBound + upperBound) / 2;
        }
        if (lowerBound == upperBound) {
            System.out.println("Bravo !" + lowerBound);
            System.out.println("End");
        }
    }

}
