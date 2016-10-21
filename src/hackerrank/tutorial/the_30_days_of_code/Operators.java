package hackerrank.tutorial.the_30_days_of_code;

import java.util.Scanner;

/**
 * Created by Aleksandr on 21/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-operators
 */
public class Operators {

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        final double mealCost = scan.nextDouble();
        final int tipPercent = scan.nextInt();
        final int taxPercent = scan.nextInt();
        scan.close();

        final double tips = mealCost * tipPercent / 100;
        final double tax = mealCost * taxPercent / 100;
        final int totalCost = (int) Math.round(mealCost + tips + tax);

        System.out.format("The total meal cost is %d dollars.", totalCost);
    }
}

