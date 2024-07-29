import java.util.Scanner;
import java.util.Random;

public class numbergame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRange = 100;
        int maxAttempts = 5;
        int rounds = 1;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange) + 1;
            int attempts = 0;
            boolean isCorrect = false;

            System.out.println("\nRound " + rounds);
            System.out.println("Guess the number between 1 and " + maxRange);

            while (attempts < maxAttempts && !isCorrect) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    isCorrect = true;
                } else if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                if (attempts == maxAttempts && !isCorrect) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber);
                }
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("yes")) {
                rounds++;
            } else {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing! You played " + rounds + " rounds.");
        scanner.close();
    }
}