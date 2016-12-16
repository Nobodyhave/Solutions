package hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-stdin-and-stdout-1
 */
public class JavaStdinAndStdoutI {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        final int a = scan.nextInt();
        final int b = scan.nextInt();
        final int c = scan.nextInt();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
