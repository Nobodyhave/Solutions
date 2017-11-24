package codechef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 03/11/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/NOV17/problems/VILTRIBE
 */
public class VillagesAndTribes {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final String s = in.next();

            int start = 0;
            while (start < s.length() && s.charAt(start) == '.') {
                start++;
            }

            if (s.isEmpty() || start >= s.length()) {
                System.out.println(0 + " " + 0);
                continue;
            }

            int countA = 0, countB = 0, prevIndex = start;
            char prevC = s.charAt(start);
            for (int i = start + 1; i < s.length(); i++) {
                final char c = s.charAt(i);
                if (c == '.') {
                    // Do nothing
                } else if (prevC == c) {
                    if (c == 'A') {
                        countA += i - prevIndex;
                    } else {
                        countB += i - prevIndex;
                    }
                    prevIndex = i;
                } else {
                    if (prevC == 'A') {
                        countA++;
                    } else {
                        countB++;
                    }
                    prevC = c;
                    prevIndex = i;
                }
            }

            if (s.charAt(s.length() - 1) == 'A') {
                countA++;
            } else if (s.charAt(s.length() - 1) == 'B') {
                countB++;
            } else {
                if (prevC == 'A') {
                    countA++;
                } else if (prevC == 'B') {
                    countB++;
                }
            }

            System.out.println(countA + " " + countB);
        }
    }
}
