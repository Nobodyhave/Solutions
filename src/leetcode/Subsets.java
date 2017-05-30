package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 30/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/subsets
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        goDeeper(result, new ArrayList<>(), 0, nums);

        return result;
    }

    private static void goDeeper(List<List<Integer>> result, List<Integer> list, int start, int[] nums) {
        result.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            goDeeper(result, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}
