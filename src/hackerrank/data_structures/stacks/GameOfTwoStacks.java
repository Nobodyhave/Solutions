package hackerrank.data_structures.stacks;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 22/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/university-codesprint-2/challenges/game-of-two-stacks
 */
public class GameOfTwoStacks {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));
        final int G = in.nextInt();
        for (int g = 0; g < G; g++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            final int x = in.nextInt();
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            final int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = in.nextInt();
            }

            int countF = 0;
            int sum = 0;
            while (countF < n && sum + a[countF] <= x) {
                sum += a[countF];
                countF++;
            }

            int maxCount = countF;
            int countS = 0;
            while (countS < m && (countF > 0 || sum <= x)) {
                if (sum > x && countF > 0) {
                    sum -= a[--countF];
                } else {
                    sum += b[countS++];
                }

                if (countF + countS > maxCount && sum <= x) {
                    maxCount = countF + countS;
                }
            }

            if (countF + countS > maxCount && sum <= x) {
                maxCount = countF + countS;
            }

            System.out.println(maxCount);
        }
    }
}
