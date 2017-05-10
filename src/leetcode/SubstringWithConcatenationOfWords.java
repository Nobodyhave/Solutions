package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aleksandr on 09/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words
 */
public class SubstringWithConcatenationOfWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.computeIfPresent(word, (s1, integer) -> integer + 1);
            counts.putIfAbsent(word, 1);
        }

        final List<Integer> result = new ArrayList<>();
        final int K = words.length;
        final int M = words[0].length();

        for (int i = 0; i < s.length() - M * K + 1; i++) {
            Map<String, Integer> copy = new HashMap<>(counts);
            for (int j = 0; j < K; j++) {
                final String word = s.substring(i + j * M, i + (j + 1) * M);
                final Integer count = copy.get(word);
                if (count == null) {
                    break;
                } else if (count == 1) {
                    copy.remove(word);
                } else {
                    copy.put(word, count - 1);
                }

                if (copy.isEmpty()) {
                    result.add(i);
                    break;
                }
            }
        }

        return result;
    }
}
