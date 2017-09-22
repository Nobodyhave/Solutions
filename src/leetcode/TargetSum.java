package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 22/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/target-sum
 */
public class TargetSum {
    private final Map<Key, Integer> CACHE = new HashMap<>();

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return dfs(nums, S, 0, 0);
    }

    private int dfs(int[] nums, int target, int sum, int start) {
        if (start == nums.length) {
            if (target == sum) {
                return 1;
            } else {
                return 0;
            }
        }

        final Key key = new Key(nums.length - start, target - sum);
        if (CACHE.containsKey(key)) {
            return CACHE.get(key);
        }

        final int count = dfs(nums, target, sum + nums[start], start + 1) + dfs(nums, target, sum - nums[start], start + 1);
        CACHE.put(key, count);

        return count;
    }

    private static class Key {
        private int remainingNums;
        private int remainingSum;

        Key(int rN, int rS) {
            remainingNums = rN;
            remainingSum = rS;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (remainingNums != key.remainingNums) return false;
            return remainingSum == key.remainingSum;
        }

        @Override
        public int hashCode() {
            int result = remainingNums;
            result = 31 * result + remainingSum;
            return result;
        }
    }
}
