package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/lisa-workbook
 */
public class LisasWorkbook {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();
        final int k = scanner.nextInt();

        int page = 0;
        int specialCount = 0;
        for (int i = 1; i <= n; i++) {
            int t = scanner.nextInt();

            for (int j = 1; j <= t; j++) {
                if (j % k == 1 || k == 1) {
                    page++;
                }
                if (page == j) {
                    specialCount++;
                }
            }
        }
        System.out.println(specialCount);
    }
}
