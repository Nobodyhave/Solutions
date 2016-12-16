package hackerrank.java.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aleksandr on 16/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/tag-content-extractor
 */
public class TagContentExtractor {
    public static void main(String[] args) {

        final Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            final String line = in.nextLine();

            int count = 0;
            final Pattern r = Pattern.compile("<(.+?)>([^<>]+)</\\1>");
            final Matcher m = r.matcher(line);
            while (m.find()) {
                if (m.group(2).length() != 0) {
                    System.out.println(m.group(2));
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("None");
            }

            testCases--;
        }
    }
}
