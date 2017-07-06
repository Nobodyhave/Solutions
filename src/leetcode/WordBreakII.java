package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 03/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/word-break-ii
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        final List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
            return result;
        } else if (!isBreakable(s, wordDict)) {
            return result;
        }

        final Set<String> words = new HashSet<>(wordDict);

        List<StringBuilder>[] dp = new ArrayList[s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new StringBuilder());

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                final String word = s.substring(j, i);
                if (!dp[j].isEmpty() && words.contains(word)) {
                    for (StringBuilder sb : dp[j]) {
                        final StringBuilder newSb = new StringBuilder(sb);
                        newSb.append(word).append(" ");
                        dp[i].add(newSb);
                    }
                }
            }
        }

        for (StringBuilder sb : dp[s.length()]) {
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
        }

        return result;
    }

    private boolean isBreakable(String s, List<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        final Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
