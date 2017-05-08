package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 05/05/2017.
 * Project Solutions
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<Integer> distinct = new ArrayList<>();
        distinct.add(nums[0]);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 3) {
                distinct.add(nums[i]);
            }
        }

        nums = new int[distinct.size()];
        for (int i = 0; i < distinct.size(); i++) {
            nums[i] = distinct.get(i);
        }

        final Set<Triplet> triplets = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            int a = nums[i];
            while (start < end) {
                if (a + nums[start] + nums[end] < 0) {
                    start++;
                } else if (a + nums[start] + nums[end] > 0) {
                    end--;
                } else {
                    triplets.add(new Triplet(a, nums[start], nums[end]));
                    end--;
                }
            }
        }

        final List<List<Integer>> result = new ArrayList<>();
        for (Triplet triplet : triplets) {
            result.add(triplet.values);
        }

        return result;
    }

    private static class Triplet {
        List<Integer> values = new ArrayList<>();

        Triplet(int a, int b, int c) {
            values.add(a);
            values.add(b);
            values.add(c);
            Collections.sort(values);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Triplet triplet = (Triplet) o;

            return values.equals(triplet.values);
        }

        @Override
        public int hashCode() {
            return values.hashCode();
        }
    }
}
