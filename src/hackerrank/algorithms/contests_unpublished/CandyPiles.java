package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 03/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-16/challenges/pile-of-candies
 */
public class CandyPiles {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] c = new int[n];
        for(int i=0; i < n; i++){
            c[i] = in.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i < n; i++) {
            if(c[i] <= min) {
                min = c[i];
                minIndex = i;
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(c[i] == min) {
                count++;
            }
        }

        min = Integer.MAX_VALUE;
        c[minIndex] *= 2;
        for(int i = 0; i < n; i++) {
            if(c[i] <= min) {
                min = c[i];
            }
        }

        System.out.println(min + " " + (count > 1 ? n : 1));
    }
}
