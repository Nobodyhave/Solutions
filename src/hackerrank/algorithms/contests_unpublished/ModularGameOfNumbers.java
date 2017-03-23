package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 22/03/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack47/challenges/modular-game-of-numbers
 */
public class ModularGameOfNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));
        final int n = in.nextInt();
        final int p = in.nextInt();
        final int q = in.nextInt();
        final int[] a = new int[p];
        for (int i = 0; i < p; i++) {
            a[i] = in.nextInt();
        }
        final int[] b = new int[q];
        for (int i = 0; i < q; i++) {
            b[i] = in.nextInt();
        }

        final int[] sumsCount = new int[2 * (n + 1)];
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                sumsCount[a[i] + b[j]]++;
            }
        }

        final int[] nums = new int[3 * (n + 1)];
        for (int i = 0; i < sumsCount.length; i++) {
            if (sumsCount[i] == 0) continue;

            for (int j = 1; j <= 2 * (n + 1); j++) {
                if ((j + i) % n != 0) {
                    nums[j] += sumsCount[i];
                }
            }
        }

        int maxCount = Integer.MIN_VALUE;
        int maxNum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxCount) {
                maxCount = nums[i];
                maxNum = i;
            }
        }

        System.out.println(maxNum);
    }
}
