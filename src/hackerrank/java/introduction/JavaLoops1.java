package hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-loops-i
 */
public class JavaLoops1 {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.format("%d x %d = %d\n", N, i, N * i);
        }
    }
}
