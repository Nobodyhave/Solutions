package hackerrank.algorithms.strings;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams
 */

import java.util.Scanner;

public class SherlockAndAnagrams {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final String s = in.next();
            int count = 0;
            for (int l = 1; l < s.length(); l++) {
                for (int s1 = 0, e1 = s1 + l; e1 <= s.length(); s1++, e1++) {
                    final int[] count1 = new int[26];
                    for (int i = s1; i < e1; i++) {
                        count1[s.charAt(i) - 'a']++;
                    }
                    for (int s2 = s1 + 1, e2 = s2 + l; e2 <= s.length(); s2++, e2++) {
                        final int[] count2 = new int[26];
                        for (int i = s2; i < e2; i++) {
                            count2[s.charAt(i) - 'a']++;
                        }

                        count++;
                        for (int i = 0; i < 26; i++) {
                            if (count1[i] != count2[i]) {
                                count--;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(count);
        }
    }
}
