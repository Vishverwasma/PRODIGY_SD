package GuessingGame;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter a Max number within what you wish to guess : ");
        int range = sc.nextInt();
        int randomNumber = random.nextInt(range) + 1;

        int guess = 0;
        int attempts = 0;

        while (guess != randomNumber) {
            System.out.print("Enter your guess (between 1 and "+range+") : ");
            guess = sc.nextInt();
            attempts++;

            if (randomNumber - guess == 0) {
                System.out.println("Congratulations! You've guessed the number.");
                System.out.println("It took you " + attempts + " attempts.");
            } else if (randomNumber - guess < 0) {
                System.out.println("Too high! Try again.");
            } else if (randomNumber - guess > 0) {
                System.out.println("Too low! Try again.");
            }
        }

        sc.close();
    }
}
