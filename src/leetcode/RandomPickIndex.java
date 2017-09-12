package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/random-pick-index
 */
public class RandomPickIndex {
    private Map<Integer, List<Integer>> map;
    private Random random;

    public RandomPickIndex(int[] nums) {
        random = new Random();
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], integer -> new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        final List<Integer> list = map.get(target);

        return list.get(random.nextInt(list.size()));
    }
}
