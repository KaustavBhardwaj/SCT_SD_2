import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("================================");

        while (playAgain) {
            // Choose difficulty
            System.out.println("\nChoose Difficulty Level:");
            System.out.println("1. Easy (1 to 50)");
            System.out.println("2. Medium (1 to 100)");
            System.out.println("3. Hard (1 to 500)");
            System.out.print("Enter choice (1/2/3): ");
            int choice = sc.nextInt();

            int upperLimit;
            switch (choice) {
                case 1:
                    upperLimit = 50;
                    break;
                case 2:
                    upperLimit = 100;
                    break;
                case 3:
                    upperLimit = 500;
                    break;
                default:
                    System.out.println("Invalid choice! Defaulting to Medium (1 to 100).");
                    upperLimit = 100;
            }

            int numberToGuess = random.nextInt(upperLimit) + 1;
            int userGuess = 0;
            int attempts = 0;

            System.out.println("\nI have generated a number between 1 and " + upperLimit + ".");
            System.out.println("Can you guess it?");

            // Loop until user guesses correctly
            while (userGuess != numberToGuess) {
                System.out.print("Enter your guess: ");
                userGuess = sc.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + numberToGuess);
                    System.out.println("Attempts taken: " + attempts);
                }
            }

            // Ask if user wants to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nThanks for playing! Goodbye.");
        sc.close();
    }
}
