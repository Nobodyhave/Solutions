package hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-stdin-stdout
 */
public class JavaStdinAndStdoutII {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        final int i = scan.nextInt();
        final double d = scan.nextDouble();
        scan.nextLine();
        final String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
