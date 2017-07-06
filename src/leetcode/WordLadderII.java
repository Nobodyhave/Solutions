package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 27/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/word-ladder
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        final List<List<String>> result = new ArrayList<>();
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || wordList.isEmpty()) {
            return result;
        }

        final Set<String> words = new HashSet<>();
        Set<List<String>> current = new HashSet<>();
        final Set<String> used = new HashSet<>();

        words.addAll(wordList);

        List<String> list = new ArrayList<>();
        list.add(beginWord);
        current.add(list);
        used.add(beginWord);
        words.remove(beginWord);

        while (!current.isEmpty() && result.isEmpty()) {
            Set<List<String>> nextSet = new HashSet<>();
            for (List<String> word : current) {
                if (word.get(word.size() - 1).equals(endWord)) {
                    result.add(new ArrayList<>(word));
                }
                StringBuilder sb = new StringBuilder(word.get(word.size() - 1));
                for (int i = 0; i < word.get(word.size() - 1).length(); i++) {
                    char old = word.get(word.size() - 1).charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(i, c);
                        String s = sb.toString();
                        if (words.contains(s) && !used.contains(s)) {
                            list = new ArrayList<>(word);
                            list.add(s);
                            nextSet.add(list);
                        }
                    }
                    sb.setCharAt(i, old);
                }
            }
            final Set<List<String>> temp = current;
            current = nextSet;
            nextSet = temp;
            nextSet.clear();

            for (List<String> word : current) {
                used.add(word.get(word.size() - 1));
                words.remove(word.get(word.size() - 1));
            }
        }

        return result;
    }
}
