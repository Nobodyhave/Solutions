package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 27/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/word-ladder
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || wordList.isEmpty()) {
            return 0;
        }

        final Set<String> words = new HashSet<>();
        Set<String> current = new HashSet<>();
        final Set<String> used = new HashSet<>();

        words.addAll(wordList);

        current.add(beginWord);
        used.add(beginWord);
        words.remove(beginWord);

        int steps = 1;
        while (!current.isEmpty()) {
            Set<String> nextSet = new HashSet<>();
            for (String word : current) {
                if (word.equals(endWord)) {
                    return steps;
                }
                StringBuilder sb = new StringBuilder(word);
                for (int i = 0; i < word.length(); i++) {
                    char old = word.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(i, c);
                        String s = sb.toString();
                        if (words.contains(s) && !used.contains(s)) {
                            nextSet.add(s);
                            used.add(s);
                            words.remove(s);
                        }
                    }
                    sb.setCharAt(i, old);
                }
            }
            final Set<String> temp = current;
            current = nextSet;
            nextSet = temp;
            nextSet.clear();
            steps++;
        }

        return 0;
    }
}
