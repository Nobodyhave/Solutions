package hackerrank.java.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-string-tokens
 */
public class JavaStringTokens {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        try {
            final String s = in.nextLine();
            final String[] tokens = s.trim().split("[ !,?.\\_'@]+");

            if (tokens.length == 1 && "".equals(tokens[0])) {
                System.out.println(0);
                return;
            }

            System.out.println(tokens.length);
            for (String token : tokens) {
                System.out.println(token);
            }
        } catch (Exception e) {
            System.out.println(0);
        }

        in.close();
    }
}
