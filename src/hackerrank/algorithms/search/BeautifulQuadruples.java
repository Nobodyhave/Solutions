package hackerrank.algorithms.search;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 22/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/xor-quadruples
 */
public class BeautifulQuadruples {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int[] limits = new int[]{in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
        Arrays.sort(limits);

        final int[] count = new int[10000];
        int numPerm = 0;
        for (int i = 1; i <= limits[2]; i++) {
            for (int j = i; j <= limits[3]; j++) {
                count[i ^ j]++;
                numPerm++;
            }
        }

        long result = 0;
        for (int b = 1; b <= limits[1]; b++) {
            for (int a = 1; a <= Math.min(limits[0], b); a++) {
                result += numPerm - count[a ^ b];
            }
            for (int d = b; d <= limits[3]; d++) {
                count[b ^ d]--;
                numPerm--;
            }
        }

        System.out.format("%d", result);
    }
}
