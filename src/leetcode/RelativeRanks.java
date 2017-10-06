package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 27/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/relative-ranks
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new String[0];
        }

        final Rank[] ranks = new Rank[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ranks[i] = new Rank(nums[i], i);
        }
        Arrays.sort(ranks);

        final String[] result = new String[nums.length];
        for (int i = 0; i < ranks.length; i++) {
            final Rank rank = ranks[i];
            if (i == 0) {
                result[rank.index] = "Gold Medal";
            } else if (i == 1) {
                result[rank.index] = "Silver Medal";
            } else if (i == 2) {
                result[rank.index] = "Bronze Medal";
            } else {
                result[rank.index] = String.valueOf(i + 1);
            }
        }

        return result;
    }

    private static class Rank implements Comparable<Rank> {
        private int score;
        private int index;

        Rank(int score, int index) {
            this.score = score;
            this.index = index;
        }

        @Override
        public int compareTo(Rank o) {
            return Integer.compare(o.score, score);
        }
    }
}
