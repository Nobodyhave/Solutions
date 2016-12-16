package hackerrank.java.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/domains/java/java-strings
 */
public class JavaRegex2 {
    public static void main(String[] args) throws FileNotFoundException {
        final String regex = "(?i)\\b([a-z]+)\\b(?:\\s+\\1\\b)+";
        final Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();
            final Matcher m = p.matcher(input);

            while (m.find()) {
                input = input.replaceAll(m.group(0), m.group(1)).replaceAll(" +", " ");
            }
            System.out.println(input);
        }

        in.close();
    }
}
