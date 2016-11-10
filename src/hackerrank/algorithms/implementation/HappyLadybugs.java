package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/happy-ladybugs
 */

import java.util.Scanner;

public class HappyLadybugs {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int Q = in.nextInt();
        for (int a0 = 0; a0 < Q; a0++) {
            final int n = in.nextInt();
            final String b = in.next();

            final int counts[] = new int[27];

            for (int i = 0; i < n; i++) {
                final char c = b.charAt(i);
                if (c == '_') {
                    counts[26]++;
                } else {
                    counts[c - 'A']++;
                }
            }

            boolean unpaired = false;
            boolean bugs = false;
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    bugs = true;
                }
                if (counts[i] > 0 && counts[i] < 2) {
                    unpaired = true;
                }
            }
            boolean empty = counts[26] > 0;

            if (!bugs) {
                System.out.println("YES");
            } else {
                if (empty && !unpaired) {
                    System.out.println("YES");
                } else if (empty) {
                    System.out.println("NO");
                } else {
                    boolean happy = true;
                    for (int i = 1; i < b.length() - 1; i++) {
                        if (b.charAt(i - 1) != b.charAt(i) && b.charAt(i) != b.charAt(i + 1)) {
                            happy = false;
                            break;
                        }
                    }

                    if (b.length() == 1) {
                        happy = false;
                    } else {
                        if (b.charAt(0) != b.charAt(1)) {
                            happy = false;
                        }
                        if (b.charAt(b.length() - 1) != b.charAt(b.length() - 2)) {
                            happy = false;
                        }
                    }

                    if (happy) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
        }
    }
}

