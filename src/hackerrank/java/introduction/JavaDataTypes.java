package hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-datatypes
 */
public class JavaDataTypes {
    public static void main(String[] argh) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            try {
                long x = in.nextLong();
                System.out.println(x + " can be fitted in:");
                if (x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE) {
                    System.out.println("* byte");
                }
                if (x >= Short.MIN_VALUE && x <= Short.MAX_VALUE) {
                    System.out.println("* short");
                }
                if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) {
                    System.out.println("* int");
                }
                System.out.println("* long");
            } catch (Exception e) {
                System.out.println(in.next() + " can't be fitted anywhere.");
            }
        }
        in.close();
    }
}
