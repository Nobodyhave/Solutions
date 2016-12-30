package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-15/challenges/an-interesting-game-1
 */
public class GamingArray {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));
        final int G = in.nextInt();
        for (int g = 0; g < G; g++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int end = n - 1;

            boolean andyWins = true;
            while (end >= 0) {
                end = findMaxInd(a, end);
                andyWins = !andyWins;
            }

            if (andyWins) {
                System.out.println("ANDY");
            } else {
                System.out.println("BOB");
            }
        }
    }

    private static int findMaxInd(int[] a, int end) {
        int max = Integer.MIN_VALUE;
        int maxInd = -1;

        for (int i = 0; i <= end; i++) {
            if (a[i] > max) {
                max = a[i];
                maxInd = i;
            }
        }

        return maxInd - 1;
    }
}
