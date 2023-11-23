import java.util.Random;

public class SnakeAndLadderGame {
    
    private static final int WINNING_POSITION = 100;

    public static void main(String[] args) 
    {
        playGame();
    }

   private static void playGame() 
   {
    int playerPosition = 0; // Starting position

    
        while (playerPosition <  WINNING_POSITION) {
        int diceNumber = rollDice();
        System.out.println("Dice Roll: " + diceNumber);

        int option = new Random().nextInt(3); // 0 - No Play, 1 - Ladder, 2 - Snake

        switch (option) {
            case 0:
                System.out.println("No Play. Player stays at position " + playerPosition);
                break;
            case 1:
                if (playerPosition + diceNumber <= WINNING_POSITION) {
                        playerPosition += diceNumber;
                        System.out.println("Ladder: Player will move ahead by " + diceNumber + " steps to " + playerPosition);
                    } else {
                        System.out.println("Ladder: But player stays at position" + playerPosition);
                    }
                    break;
            case 2:
                playerPosition =  playerPosition - diceNumber;
                if (playerPosition < 0) {
                    playerPosition = 0;
                }
                System.out.println("Snake: Player will move back by " + diceNumber + " of steps to " + playerPosition);
                break;
        }

        System.out.println("Player Position: " + playerPosition);
    }

    System.out.println("Final Player Position: " + playerPosition);
}

    private static int rollDice() 
    {
      Random random = new Random();
      return random.nextInt(6) + 1; // Returns a random number between 1 and 6
    }

}

    