package hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-regex
 */
public class JavaRegex {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            final String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }

    private static class MyRegex {
        private String pattern = "^(([0-9]|[0-9][0-9]|0[0-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|0[0-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
    }
}
