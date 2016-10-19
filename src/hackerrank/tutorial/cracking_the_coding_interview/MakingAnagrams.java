package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 19/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-making-anagrams
 */

import java.util.Scanner;

public class MakingAnagrams {
    public static int numberNeeded(String first, String second) {
        int[] counts = new int[26];

        for (int i = 0; i < first.length(); i++) {
            counts[first.charAt(i) - 'a']++;
        }

        for (int i = 0; i < second.length(); i++) {
            counts[second.charAt(i) - 'a']--;
        }

        int count = 0;
        for (int i = 0; i < counts.length; i++) {
            count += Math.abs(counts[i]);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

