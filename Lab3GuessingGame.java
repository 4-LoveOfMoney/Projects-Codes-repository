import java.util.Scanner;

public class Lab3GuessingGame {
    // Class constant for the maximum number used in the guessing game
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        instructions();
        playGame(scanner);
    }

    // Method to give instructions to the user
    private static void instructions() {
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and " + MAX_NUMBER);
        System.out.println("and will allow you to guess until you get it.");
        System.out.println("For each guess, I will tell you whether the");
        System.out.println("right answer is higher or lower than your guess.");
        System.out.println("I'm thinking of a number...");
    }

    // Method to play one game with the user
    private static void playGame(Scanner scanner) {
        int totalGames = 0;
        int totalGuesses = 0;
        int maxGuesses = 0;
        while (true) {
            int numberToGuess = (int) (Math.random() * MAX_NUMBER) + 1;
            int guesses = 0;
            while (true) {
                System.out.print("Your guess? ");
                int guess = scanner.nextInt();
                guesses++;
                if (guess == numberToGuess) {
                    System.out.println("You got it right in " + guesses + " guesses");
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("higher");
                } else {
                    System.out.println("lower");
                }
            }
            totalGames++;
            totalGuesses += guesses;
            maxGuesses = Math.max(maxGuesses, guesses);
            System.out.print("Do you want to play again? ");
            String playAgain = scanner.next();
            if (!playAgain.toLowerCase().startsWith("y")) {
                break;
            }
        }
        // Call the reportResults method to display overall results
        reportResults(totalGames, totalGuesses, maxGuesses);
    }

    // Method to report overall results to the user
    private static void reportResults(int totalGames, int totalGuesses, int maxGuesses) {
        System.out.println("Overall results:");
        System.out.println("total games = " + totalGames);
        System.out.println("total guesses = " + totalGuesses);
        System.out.println("guesses/game = " + (double) totalGuesses / totalGames);
        System.out.println("max guesses = " + maxGuesses);
    }
}
