package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 02/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/top-k-frequent-words
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        final List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        final Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        final PriorityQueue<WordFreq> pq = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.add(new WordFreq(entry.getKey(), entry.getValue()));
            } else if (entry.getValue() > pq.peek().freq || (entry.getValue() == pq.peek().freq && entry.getKey().compareTo(pq.peek().word) < 0)) {
                pq.poll();
                pq.add(new WordFreq(entry.getKey(), entry.getValue()));
            }
        }

        final Deque<String> deque = new ArrayDeque<>();
        while (!pq.isEmpty()) {
            deque.addFirst(pq.poll().word);
        }

        while (k > 0) {
            result.add(deque.pollFirst());
            k--;
        }

        return result;
    }

    private static class WordFreq implements Comparable<WordFreq> {
        private String word;
        private int freq;

        WordFreq(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }

        @Override
        public int compareTo(WordFreq o) {
            int result = Integer.compare(freq, o.freq);
            if (result == 0) {
                result = o.word.compareTo(word);
            }

            return result;
        }
    }
}
