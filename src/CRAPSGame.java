import java.util.Random;
import java.util.Scanner;

public class CRAPSGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean done = false;
        boolean cont = false;

        do {
            //collect initial dice roll
            int diceSum = RollDice(rand);
            //collect point if applicable
            int point = Points(diceSum);
            //If they have a point value
            if (point != 0) {
                do {
                    //loop dice rolls...
                    diceSum = RollDice(rand);
                    //...until they get a 7 which they lose
                    if (diceSum == 7) {
                        System.out.println("Craps, You Lose");
                        done = true;
                    }
                    //...until they meet the point value which they win
                    else if (diceSum == point) {
                        System.out.println("You Win");
                        done = true;
                    }
                    //Otherwise they need to re-roll
                    else{
                        System.out.println("Re-Roll");
                        done = false;
                    }
                    System.out.println("");
                }
                while (done == false);
            }
            //Checking if user wants to continue game
            cont = SafeInput.getYNConfirm(scan, "Continue?");
            System.out.println("");
        }
        while (cont == false);



    }
    //Method for rolling dice
    public static int RollDice(Random rand){
        //Obtain individual die values
        int die1 = rand.nextInt(6) + 1;
        System.out.println("Die1: " + die1);
        int die2 = rand.nextInt(6) + 1;
        System.out.println("Die2: " + die2);
        // Gaussian range from 2 to 12 as in rolling two dice
        int crapsRoll = die1 + die2;
        System.out.println("Sum: " + crapsRoll);

        return crapsRoll;
    }
    //Method for rolling for point
    public static int Points(int diceSum){
        int point = 0;
        //checking for whether point needs to happen
        switch (diceSum){
            //User loses if sum = 2 || 3 || 12
            case 2:
            case 3:
            case 12:
                System.out.println("Craps, You Lose");
                break;
            //User wins if sum = 7 || 11
            case 7:
            case 11:
                System.out.println("Natural, You Win");
                break;
            //All other possible values mean point condition occurs
            default:
                point = diceSum;
                System.out.println("The Sum is now the Point");
                System.out.println("");
        }
        return point;
    }
}