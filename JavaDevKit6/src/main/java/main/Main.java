package main;
import Paradox.Game;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Main
{
    private static final int TOTAL_TRIALS = 1000;
    private static final Map<Integer, Boolean> results = new HashMap<>();
    private static final Map<Integer, List<Integer>> moves = new HashMap<>();

    public static void main(String[] args)
    {


        for (int i = 1; i <= TOTAL_TRIALS; i++) {
            boolean win = Game.playMontyHallGame(moves, i);
            results.put(i, win);
        }



        int positiveResults = (int) results.values().stream().filter(Boolean::valueOf).count();
        int negativeResults = TOTAL_TRIALS - positiveResults;
        double positivePercentage = (double) positiveResults / TOTAL_TRIALS * 100;

        PrintResult(moves);

        System.out.println("\nСтатистика:");
        System.out.println("Позитивные результаты: " + positiveResults);
        System.out.println("Негативные результаты: " + negativeResults);
        System.out.println("Процент позитивных результатов: " + positivePercentage + "%");


    }









    public static void PrintResult(Map<Integer, List<Integer>> moves)
    {
        for (int i = 1; i <= TOTAL_TRIALS; i++)
        {
            List<Integer> gameMoves = moves.get(i);

            if (gameMoves != null && gameMoves.size() >= 3)
            {
                int playerChoice = gameMoves.get(0);
                int goatDoor = gameMoves.get(1);
                int switchChoice = gameMoves.get(2);
                boolean win = results.get(i);

                String explanation = " Игрок выбрал дверь " + playerChoice + ", " + " Ведущий открывает дверь " + goatDoor + ",";
                if (switchChoice > 0) {
                    if (switchChoice == playerChoice) {
                        explanation += " Игрок решает оставить дверь ";
                    } else {
                        explanation += " Игрок выбирает дверь " + switchChoice;
                    }
                } else {
                    explanation += " Игрок решает оставить дверь ";
                }
                System.out.println("Игра " + i + ": " + explanation);
                if (win) {
                    System.out.println("Игрок выиграл");
                } else {
                    System.out.println("Игрок проиграл.");
                }
            } else {
                System.out.println("Ошибка при обработке хода игры " + i);
            }
        }
    }

}