package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 15/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/permutations
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        final List<List<Integer>> result = new ArrayList<>();

        goDeeper(result, new ArrayList<>(), nums, new boolean[nums.length]);

        return result;
    }

    private static void goDeeper(List<List<Integer>> result, List<Integer> permutation, int[] nums, boolean[] used) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                permutation.add(nums[i]);
                goDeeper(result, permutation, nums, used);
                permutation.remove(permutation.size() - 1);
                used[i] = false;
            }
        }
    }
}
