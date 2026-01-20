import java.util.Random;
import java.util.Scanner;

class GameDetails {
    private int gussYourNumber;
    private int computerGussedNumber; // private ko hum same class mein use kr sakte hai.

    public GameDetails() {
        Random random = new Random();
        /*
         * Agar mein ek variable ko under a method declare krta hun toh woh uss method
         * ka local variable hoga jise bass, uss method mein hi use
         * kiya ja sakta hai.
         */
        computerGussedNumber = random.nextInt(101);
    }


    public void setGussYourNumber(Scanner sc) {
        System.out.print("Guss a number from 1 to 100 : ");
        this.gussYourNumber = sc.nextInt();

    }

    public boolean winnerDecision() {
        System.out.println();
        if (gussYourNumber == computerGussedNumber) {
            System.out.println("You gussed it!");
            return false;
        } else if (gussYourNumber > computerGussedNumber) {
            System.out.println("You gussed a bigger number.");
            return true;
        } else {
            System.out.println("You gussed a smaller number.");
            return true;
        }
    }

    public void winnerDeclaration(int numberOfGusses) {
        System.out.println("Number of gusses : " + numberOfGusses);
        System.out.println("Your score : "+(100-numberOfGusses));
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                                [Game-End]                                        ");
    }
}


public class Game_GussTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameDetails players = new GameDetails();

        boolean condition = true;
        int numberOfGusses = 0;

        System.out.println("                                [Game-Start]                                          ");
        while (condition == true) {
            System.out.println("----------------------------------------------------------------------------------");
            players.setGussYourNumber(sc);

            // agar bass method ko call krege toh loop stop nhi hoga that's why we need to
            // store that return value.As we are doing.
            condition = players.winnerDecision();
            numberOfGusses++;
        }

        players.winnerDeclaration(numberOfGusses);
        sc.close();
    }
}
