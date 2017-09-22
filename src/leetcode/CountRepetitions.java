package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 18/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/count-the-repetitions
 */
public class CountRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (s1 == null || s2 == null || n1 <= 0 || n2 <= 0) {
            return 0;
        }

        final Map<Character, Integer> counts1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            counts1.put(s1.charAt(i), counts1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        final Map<Character, Integer> counts2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            counts2.put(s2.charAt(i), counts2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : counts2.entrySet()) {
            if (!counts1.containsKey(entry.getKey())) {
                return 0;
            }
        }

        final int[] repeatCount = new int[s2.length() + 1];
        final int[] nextIndex = new int[s2.length() + 1];
        int j = 0, count = 0;
        for (int k = 1; k <= n1 + 1; k++) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                    if (j == s2.length()) {
                        j = 0;
                        ++count;
                    }
                }
            }

            repeatCount[k] = count;
            nextIndex[k] = j;

            for (int start = 0; start < k; ++start) {
                if (nextIndex[start] == j) {
                    int prefixCount = repeatCount[start];
                    int patternCount = (repeatCount[k] - repeatCount[start]) * (n1 - start) / (k - start);

                    return (prefixCount + patternCount) / n2;
                }
            }
        }

        return repeatCount[n1] / n2;
    }
}
