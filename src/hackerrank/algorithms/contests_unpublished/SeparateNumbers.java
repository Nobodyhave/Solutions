package hackerrank.algorithms.contests_unpublished;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 22/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/university-codesprint-2/challenges/separate-the-numbers
 */
public class SeparateNumbers {
    public static void main(String[] args) throws IOException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));
        final int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            final String s = in.next();

            if (s.charAt(0) == '0' || s.length() == 1) {
                System.out.println("NO");
                continue;
            }

            final int mid = s.length() / 2;
            boolean isFound = false;
            String first = "";
            for (int l = 1; l <= mid; l++) {
                if (s.charAt(l) == '0') {
                    continue;
                }
                int start = 0, end = l;
                String num = s.substring(start, end);
                first = num;
                while (true) {
                    start = end;
                    end += num.length();

                    boolean allNine = true;
                    for (int j = 0; j < num.length(); j++) {
                        if (num.charAt(j) != '9') {
                            allNine = false;
                        }
                    }

                    if (allNine) {
                        end++;
                    }

                    if (start == s.length()) {
                        isFound = true;
                        break;
                    }
                    if (start >= s.length() || end > s.length()) {
                        break;
                    }

                    String num2 = s.substring(start, end);
                    if (Long.parseLong(num) + 1 != Long.parseLong(num2)) {
                        break;
                    }
                    num = num2;
                }

                if (isFound) {
                    break;
                }
            }

            if (isFound) {
                System.out.println("YES " + first);
            } else {
                System.out.println("NO");
            }
        }
    }
}
