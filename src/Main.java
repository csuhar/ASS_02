import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        boolean keepPlaying = true;
        int die1;
        int die2;
        int sum;

        while (keepPlaying) {
            System.out.println("YEAH ROLLING THE DICE...");
            die1 = rand.nextInt(6) + 1;
            die2 = rand.nextInt(6) + 1;
            sum = die1 + die2;

            System.out.println("You rolled a: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("HAHAHA Craps! You lost.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Oh WOW ! You got a natural! you win!");
            } else {
                System.out.println("your point is now " + sum + ". keep going.");
                int point = sum;
                boolean pointStillInPlay = true;

                while (pointStillInPlay) {
                    System.out.println("Rolling again, trying to hit " + point + "... or maybe a 7...");
                    die1 = rand.nextInt(6) + 1;
                    die2 = rand.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == 7) {
                        System.out.println("Danggggg, you rolled a 7 and lost. Bummer.");
                        pointStillInPlay = false;
                    } else if (sum == point) {
                        System.out.println("Yay! You made your point and won!");
                        pointStillInPlay = false;
                    } else {
                        System.out.println("Still trying to make the point...");
                    }
                }
            }

            System.out.print("Wanna play again? (y/n): ");
            String answer = in.nextLine().trim();
            if (!answer.equalsIgnoreCase("y")) {
                keepPlaying = false;
            }
        }

        System.out.println("Alright, thanks for playing!");
        in.close();
    }
}
