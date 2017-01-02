package hackerrank.algorithms.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string
 */
public class SherlockAndValidString {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final String s = in.next();
        in.close();

        final int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        Arrays.sort(count);

        int minCount = Integer.MAX_VALUE;
        int maxCount = Integer.MIN_VALUE;
        final int[] counts = new int[count[count.length - 1] + 1];
        for (int i = 0; i < count.length; i++) {
            counts[count[i]]++;
            if (count[i] > 0 && count[i] < minCount) {
                minCount = count[i];
            }
            if (count[i] > maxCount) {
                maxCount = count[i];
            }
        }

        final List<Integer> countsList = new ArrayList<>();
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] != 0) {
                countsList.add(counts[i]);
            }
        }

        if (countsList.size() == 1) {
            // All frequencies are the same
            System.out.println("YES");
        } else if (counts[1] == 1 && countsList.size() == 2) {
            // All frequencies are the same except 1 single letter
            System.out.println("YES");
        } else if (countsList.size() == 2 && (countsList.get(1) == 1 || countsList.get(0) == 1) && (maxCount - minCount == 1)) {
            // Only one one-step difference exists
            System.out.println("YES");
        } else {
            // Frequencies differ more then 1 for 1 letter or for 2 or more letters
            System.out.println("NO");
        }
    }
}
