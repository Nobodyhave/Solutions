package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 02/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/stickers-to-spell-word
 */
public class StickersToSpellWord {
    private final Map<String, Integer> CACHE = new HashMap<>();

    public int minStickers(String[] stickers, String target) {
        if (stickers == null || target == null) {
            return -1;
        } else if (stickers.length == 0 && target.length() == 0) {
            return 0;
        }

        final int[][] letters = new int[stickers.length][26];

        for (int i = 0; i < stickers.length; i++) {
            final String s = stickers[i];
            for (int j = 0; j < s.length(); j++) {
                letters[i][s.charAt(j) - 'a']++;
            }
        }

        CACHE.put("", 0);

        return dfs(letters, target);
    }

    private int dfs(int[][] letters, String target) {
        if (CACHE.containsKey(target)) {
            return CACHE.get(target);
        }

        final int[] tCount = new int[26];
        for (int i = 0; i < target.length(); i++) {
            tCount[target.charAt(i) - 'a']++;
        }

        int result = Integer.MAX_VALUE;
        for (int[] sticker : letters) {
            if (sticker[target.charAt(0) - 'a'] == 0) {
                continue;
            }

            final StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (tCount[j] > 0) {
                    for (int k = 0; k < Math.max(0, tCount[j] - sticker[j]); k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }

            final int count = dfs(letters, sb.toString());
            if (count != -1) {
                result = Math.min(result, count + 1);
            }
        }

        CACHE.put(target, result == Integer.MAX_VALUE ? -1 : result);

        return CACHE.get(target);
    }
}
