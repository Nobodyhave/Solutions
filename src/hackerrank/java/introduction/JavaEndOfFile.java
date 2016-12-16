package hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-end-of-file
 */
public class JavaEndOfFile {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        int i = 1;
        while (in.hasNextLine()) {
            System.out.format("%d %s\n", i, in.nextLine());
            i++;
        }
    }
}
