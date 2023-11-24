import java.util.Random;
import java.util.Scanner;

public class SnakeLadderGame {

    private static final int WINNING_POSITION =100;

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        int player1Position = 0;
        int player2Position = 0;
        int currentPlayer = 1; // To keep track of the current player
        int diceRolls = 0;

        while (player1Position < WINNING_POSITION || player2Position < WINNING_POSITION) {
            int diceNumber = rollDice();
            diceRolls++;
            System.out.println("Player " + currentPlayer + " Dice Roll: " + diceNumber);
            

             int option = new Random().nextInt(3); // 0 - No Play, 1 - Ladder, 2 - Snake
        
            switch (option) {
                case 0:
                    System.out.println("No Play.");
                    // System.out.println("No Play. Player " + currentPlayer + " stays at position " + getPosition(currentPlayer, player1Position, player2Position));
                    break;
                case 1:
                    int newPosition = updatePosition(currentPlayer, diceNumber, player1Position, player2Position);
                    if(currentPlayer == 1)
                    {
                        player1Position = newPosition;
                    }
                    else
                    player2Position = newPosition;
                    System.out.println("Ladder! Player " + currentPlayer + " moves ahead by " + diceNumber + " positions to " + newPosition);
                    if (newPosition == WINNING_POSITION) {
                        System.out.println("Player " + currentPlayer + " wins!");
                        System.out.println("Number of times the dice was played to win the game: " + diceRolls);
                        return; // Game ends
                    }
                    break;
                case 2:
                     int newPP=updatePosition(currentPlayer, -diceNumber, player1Position, player2Position);
                     if(currentPlayer == 1)
                    {
                        player1Position = newPP;
                    }
                    else
                    player2Position = newPP;
                    System.out.println("Snake! Player " + currentPlayer + " moves back by " + diceNumber + " positions to " + newPP) ;
                    break;
            }

            System.out.println("Player Positions: Player 1 - " + player1Position + ", Player 2 - " + player2Position);

            // Switch to the other player for the next turn
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }
    }

private static int updatePosition(int currentPlayer, int diceNumber, int player1Position, int player2Position) {
    if (currentPlayer == 1) {
        int newPosition = player1Position + diceNumber;
        if (newPosition <= WINNING_POSITION) {
            player1Position = newPosition;
        }
        if (player1Position < 0) {
            player1Position = 0;
        }
        return player1Position;
    } else {
        int newPosition = player2Position + diceNumber;
        if (newPosition <= WINNING_POSITION) {
            player2Position = newPosition;
        }
        if (player2Position < 0) {
            player2Position = 0;
        }
        return player2Position;
    }
}


    private static int rollDice() 
    {
      Random random = new Random();
      return random.nextInt(6) + 1; // Returns a random number between 1 and 6
    }
}
