package hackerrank.tutorial.the_30_days_of_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aleksandr on 16/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-regex-patterns
 */
public class RegexPatternsAndIntroToDatabases {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final List<String> names = new ArrayList<>();
        final Pattern pattern = Pattern.compile("[a-z/.]+@gmail.com");
        for (int i = 0; i < N; i++) {
            final String name = in.next();
            final String email = in.next();
            final Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                names.add(name);
            }
        }

        Collections.sort(names);

        names.stream().forEach(System.out::println);
    }
}
