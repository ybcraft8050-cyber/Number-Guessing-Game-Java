import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("==================================");
        System.out.println("🎮 NUMBER GUESSING GAME");
        System.out.println("==================================");

        while (playAgain) {

            int number = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\nGuess the number between 1 to 100");
            System.out.println("You have " + maxAttempts + " attempts!");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("🎉 Correct Guess!");
                    System.out.println("Attempts used: " + attempts);

                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("Score this round: " + score);
                    guessed = true;
                    break;
                } 
                else if (guess > number) {
                    System.out.println("📉 Too High!");
                } 
                else {
                    System.out.println("📈 Too Low!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("\n❌ Out of attempts! Number was: " + number);
            }

            System.out.println("\nDo you want to play again? (1 = Yes / 0 = No)");
            int choice = sc.nextInt();

            if (choice != 1) {
                playAgain = false;
            }
        }

        System.out.println("\n🏁 GAME OVER");
        System.out.println("Total Score: " + totalScore);

        sc.close();
    }
}
