package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        logger.log("Entrez votre hypothÃ¨se : ");
        return scanner.nextLong();
    }

    @Override
    public void respond(boolean isGuessLower) {
        if (isGuessLower) {
            logger.log("C'est plus grand !");
        } else {
            logger.log("C'est plus petit !");
        }
    }
}