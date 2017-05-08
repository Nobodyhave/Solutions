package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 05/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/4sum
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        final List<Integer> distinct = new ArrayList<>();
        distinct.add(nums[0]);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 4) {
                distinct.add(nums[i]);
            }
        }

        nums = new int[distinct.size()];
        for (int i = 0; i < distinct.size(); i++) {
            nums[i] = distinct.get(i);
        }

        final Map<Integer, List<Pair>> map = new TreeMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                final int sum = nums[i] + nums[j];
                final List<Pair> pairs = map.computeIfAbsent(sum, k -> new ArrayList<>());
                pairs.add(new Pair(i, j));
            }
        }

        final Set<Quadruple> quadruplets = new HashSet<>();

        for (Map.Entry<Integer, List<Pair>> entry : map.entrySet()) {
            List<Pair> aList = entry.getValue();
            List<Pair> bList = map.get(target - entry.getKey());
            if (bList != null) {
                for (int i = 0; i < aList.size(); i++) {
                    for (int j = 0; j < bList.size(); j++) {
                        Pair a = aList.get(i);
                        Pair b = bList.get(j);
                        if (a.a != b.a && a.a != b.b && a.b != b.a && a.b != b.b) {
                            quadruplets.add(new Quadruple(nums[a.a], nums[a.b], nums[b.a], nums[b.b]));
                        }
                    }
                }
            }
        }

        final List<List<Integer>> result = new ArrayList<>();
        for (Quadruple quadruple : quadruplets) {
            result.add(quadruple.values);
        }

        return result;
    }

    private static class Pair {
        private int a;
        private int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static class Quadruple {
        private List<Integer> values = new ArrayList<>();

        Quadruple(int a, int b, int c, int d) {
            values.add(a);
            values.add(b);
            values.add(c);
            values.add(d);
            Collections.sort(values);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Quadruple quadruple = (Quadruple) o;

            return values.equals(quadruple.values);
        }

        @Override
        public int hashCode() {
            return values.hashCode();
        }
    }
}
