package Paradox;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {

    public static boolean playMontyHallGame(Map<Integer, List<Integer>> moves, int gameNumber) {
        Random random = new Random();

        int carDoor = random.nextInt(3) + 1;
        int playerChoice = random.nextInt(3) + 1;

        int goatDoor;
        do {
            goatDoor = random.nextInt(3) + 1;
        } while (goatDoor == carDoor || goatDoor == playerChoice);

        boolean switchChoice = random.nextBoolean();

        if (switchChoice) {
            do {
                playerChoice = random.nextInt(3) + 1;
            } while (playerChoice == goatDoor);
        }


        List<Integer> gameMoves = new ArrayList<>();
        gameMoves.add(playerChoice);
        gameMoves.add(goatDoor);
        gameMoves.add(switchChoice ? playerChoice : 0);
        moves.put(gameNumber, gameMoves);

        return playerChoice == carDoor;
    }
}
