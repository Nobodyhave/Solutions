package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 24/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/top-k-frequent-elements
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        final List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        final Map<Integer, Integer> sizeMap = new HashMap<>();
        for (int num : nums) {
            sizeMap.computeIfPresent(num, (key, value) -> value + 1);
            sizeMap.putIfAbsent(num, 1);
        }

        final Entry[] freq = new Entry[sizeMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : sizeMap.entrySet()) {
            freq[i++] = new Entry(entry.getKey(), entry.getValue());
        }

        Arrays.sort(freq);

        for (i = 0; i < k; i++) {
            result.add(freq[i].val);
        }

        return result;
    }

    private static class Entry implements Comparable<Entry> {
        private int val;
        private int size;

        Entry(int val, int size) {
            this.val = val;
            this.size = size;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(o.size, size);
        }
    }
}
