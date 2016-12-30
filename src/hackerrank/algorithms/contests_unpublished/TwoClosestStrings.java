package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/sears-dots-arrows/challenges/two-closest-strings
 */
public class TwoClosestStrings {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final StringBuilder sb = new StringBuilder();
            final String str = in.next();
            final int K = in.nextInt();

            int k = 0, pos = 0;
            while (k < K && pos < str.length()) {
                sb.append('a');
                if (str.charAt(pos) != 'a') {
                    k++;
                }
                pos++;
            }

            if (k == K) {
                for (int i = pos; i < str.length(); i++) {
                    sb.append(str.charAt(i));
                }
            } else {
                pos = sb.length() - 1;
                while (k < K) {
                    if (str.charAt(pos) == 'a') {
                        sb.replace(pos, pos + 1, "b");
                        k++;
                    }
                    pos--;
                }
            }

            System.out.println(sb.toString());
        }
    }
}
