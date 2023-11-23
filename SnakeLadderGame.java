import java.util.Random;

public class SnakeAndLadderGame {

    public static void main(String[] args) 
    {
        playGame();
    }

   private static void playGame() 
   {
    int playerPosition = 0; // Starting position

    
        int diceNumber = rollDice();
        System.out.println("Dice Roll: " + diceNumber);
        int option = new Random().nextInt(3);
        
        switch (option) {
            case 0:
                System.out.println("No Play. Player stays at position " + playerPosition);
                break;
            case 1:
                playerPosition += diceNumber;
                System.out.println("Ladder: Player will go ahead " + diceNumber + " steps to " + playerPosition);
                break;
            case 2:
                playerPosition -= diceNumber;
                System.out.println("Snake: Player will move back by " + diceNumber + " steps to " + playerPosition);
                break;
        }

        System.out.println("Player Position: " + playerPosition);
        System.out.println("Final Player Position: " + playerPosition);

    
}

    private static int rollDice() 
    {
      Random random = new Random();
      return random.nextInt(6) + 1; // Returns a random number between 1 and 6
    }

}

    