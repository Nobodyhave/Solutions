package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 24/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor
 */

import java.util.Arrays;
import java.util.Scanner;

public class IceCreamParlor {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final int m = in.nextInt();
            final int N = in.nextInt();
            final int[] prices = new int[N];
            for (int n = 0; n < N; n++) {
                prices[n] = in.nextInt();
            }

            final int[] pricesCopy = new int[N];
            System.arraycopy(prices, 0, pricesCopy, 0, N);
            Arrays.sort(prices);

            int left = 0, right = N - 1;
            while (left < right) {
                if (prices[left] + prices[right] == m) {
                    int indL = -1, indR = -1;
                    for (int i = 0; i < N; i++) {
                        if (prices[left] == pricesCopy[i] && indL == -1) {
                            indL = i;
                        }
                        if (prices[right] == pricesCopy[i] && indR == -1 && i != indL) {
                            indR = i;
                        }
                        if (indL != -1 && indR != -1) {
                            break;
                        }
                    }
                    indL++;
                    indR++;
                    System.out.println(Math.min(indL, indR) + " " + Math.max(indL, indR));
                    break;
                } else if (prices[left] + prices[right] < m) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
    }
}
