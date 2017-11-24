package codechef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Aleksandr on 06/11/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/NOV17/problems/CHEFHPAL
 */
public class ChefHatePalindromes {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        final Map<Integer, String> map = createStrings();
        final Map<Integer, String> mapForTwo = createStringsForTwo();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int A = in.nextInt();

            if (A != 2) {
                System.out.format("%d %s\n", getLength(N, A), map.get(A).substring(0, N));
            } else {
                System.out.format("%d %s\n", getLength(N, A), mapForTwo.get(N < 9 ? N : 9).substring(0, N));
            }
        }
    }

    private static int getLength(int N, int A) {
        if (A == 1) {
            return N;
        } else if (A > 2) {
            return 1;
        } else {
            if (N <= 2) {
                return 1;
            } else if (N <= 4) {
                return 2;
            } else if (N <= 8) {
                return 3;
            } else {
                return 4;
            }
        }
    }

    private static Map<Integer, String> createStringsForTwo() {
        final int N = 100020;
        final Map<Integer, String> map = new HashMap<>();

        map.put(1, "a");
        map.put(2, "ab");
        map.put(3, "aab");
        map.put(4, "aabb");
        map.put(5, "aaaba");
        map.put(6, "aaabab");
        map.put(7, "aaababb");
        map.put(8, "aaababbb");

        final StringBuilder sb = new StringBuilder();
        sb.append("aaaa");
        final String period = "babbaa";
        while (sb.length() < N) {
            sb.append(period);
        }

        map.put(9, sb.toString());

        return map;
    }

    private static Map<Integer, String> createStrings() {
        final Map<Integer, String> map = new HashMap<>();
        final int N = 100020;
        for (int i = 1; i <= 26; i++) {
            final StringBuilder sb = new StringBuilder();
            if (i == 1) {
                for (int j = 0; j < N; j++) {
                    sb.append('a');
                }
            } else if (i > 2) {
                for (int j = 0; sb.length() < N; j++) {
                    sb.append((char) ('a' + j % i));
                }
            }
            map.put(i, sb.toString());
        }

        return map;
    }
}
