import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int start = 1, end = 100;
        int maxAttempts = 10;
        int score = 0;
        int rounds = 0;
        boolean playAgain = true;

        while (playAgain) {
            int number = random.nextInt(end - start + 1) + start;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nNew round! Guess the number between " + start + " and " + end + ". You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < number) {
                    System.out.println("Too low!");
                } else if (guess > number) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct!");
                    guessedCorrectly = true;
                    score++;
                    System.out.println("You guessed the number in " + attempts + " attempts.");
                }

                if (!guessedCorrectly) {
                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + number + ".");
            }

            rounds++;
            System.out.println("Rounds played: " + rounds + ", Score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine(); // Consume the newline character
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Game over! You played " + rounds + " rounds with a score of " + score + ".");
        scanner.close();
    }
}
