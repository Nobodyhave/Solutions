package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Aleksandr on 11/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/largest-number
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        final String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new NumberComparator());

        if (strs[0].charAt(0) == '0') {
            return "0";
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }

        return sb.toString();
    }

    private static class NumberComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            final String str1 = s1 + s2;
            final String str2 = s2 + s1;

            return str2.compareTo(str1);
        }
    }
}
