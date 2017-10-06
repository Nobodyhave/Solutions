package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Aleksandr on 02/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/beautiful-arrangement
 */
public class BeautifulArrangement {
    private final Map<Integer, Set<Integer>> DIVISORS = new HashMap<>();

    public int countArrangement(int N) {
        if (N < 1) {
            return 0;
        }
        calculateDivisors(N);

        return dfs(new int[N], 0, new boolean[N]);
    }

    private int dfs(int[] nums, int start, boolean[] used) {
        if (start == nums.length) {
            return checkPermutation(nums) ? 1 : 0;
        }

        int sum = 0;
        for (int i = 0; i < used.length; i++) {
            if (!used[i] && ((start + 1) % (i + 1) == 0 || (i + 1) % (start + 1) == 0)) {
                used[i] = true;
                int prev = nums[start];
                nums[start] = i + 1;
                sum += dfs(nums, start + 1, used);
                nums[start] = prev;
                used[i] = false;
            }
        }

        return sum;
    }

    private boolean checkPermutation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % (i + 1) != 0 && (i + 1) % nums[i] != 0) {
                return false;
            }
        }

        return true;
    }

    private void calculateDivisors(int N) {
        for (int i = 1; i <= N; i++) {
            DIVISORS.put(i, new HashSet<>());

            final int sqrt = (int) Math.sqrt(N);
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    DIVISORS.get(i).add(j);
                    DIVISORS.get(i).add(i / j);
                }
            }
        }
    }
}
