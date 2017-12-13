package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Aleksandr on 30/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/sentence-similarity
 */
public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null || words1.length != words2.length) {
            return false;
        }

        final Map<String, Set<String>> to = new HashMap<>();
        final Map<String, Set<String>> from = new HashMap<>();

        for (String[] pair : pairs) {
            to.computeIfAbsent(pair[0], key -> new HashSet<>());
            from.computeIfAbsent(pair[1], key -> new HashSet<>());
            to.get(pair[0]).add(pair[1]);
            from.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < words1.length; i++) {
            final String word1 = words1[i];
            final String word2 = words2[i];

            if (!word1.equals(word2)
                    && !(to.get(word1) != null && to.get(word1).contains(word2))
                    && !(from.get(word1) != null && from.get(word1).contains(word2))) {
                return false;
            }
        }

        return true;
    }
}
