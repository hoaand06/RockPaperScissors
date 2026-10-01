import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};
        int wins = 0;
        int losses = 0;
        int ties = 0;

        System.out.println("=== Welcome to Rock, Paper, Scissors! ===");
        System.out.println("Type 'rock', 'paper', or 'scissors' to play. Type 'quit' to exit.\n");

        while (true) {
            System.out.print("Your choice: ");
            String playerChoice = scanner.nextLine().trim().toLowerCase();

            if (playerChoice.equals("quit")) {
                System.out.println("\nThanks for playing! Final Score:");
                System.out.println("Wins: " + wins + " | Losses: " + losses + " | Ties: " + ties);
                break;
            }

            // Validate player input
            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
                continue;
            }

            // Computer makes a choice
            String computerChoice = choices[random.nextInt(choices.length)];
            System.out.println("Computer chose: " + computerChoice);

            // Determine the winner
            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!\n");
                ties++;
            } else if (
                (playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper"))
            ) {
                System.out.println("🎉 You win this round!\n");
                wins++;
            } else {
                System.out.println("💻 Computer wins this round!\n");
                losses++;
            }
        }

        scanner.close();
    }
}