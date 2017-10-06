package leetcode;

/**
 * Created by Aleksandr on 04/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/optimal-division
 */
public class OptimalDivision {
    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        final double[] dNums = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dNums[i] = nums[i];
        }

        return divide(dNums, 0, nums.length - 1, true).s;
    }

    private Result divide(double[] nums, int start, int end, boolean isMax) {
        if (start == end) {
            return new Result(nums[start], String.valueOf((int)nums[start]));
        }

        Result leftRes = divide(nums, start + 1, end, !isMax);
        Result rightRes = divide(nums, start, end - 1, isMax);
        double leftDiv = nums[start] / leftRes.result;
        double rightDiv = rightRes.result / nums[end];

        final Result divRes = new Result();
        if (isMax) {
            if (leftDiv > rightDiv) {
                divRes.result = leftDiv;
                divRes.s = (int) nums[start] + "/(" + leftRes.s + ")";
            } else {
                divRes.result = rightDiv;
                divRes.s = rightRes.s + "/" + (int) nums[end];
            }
        } else {
            if (leftDiv >= rightDiv) {
                divRes.result = rightDiv;
                divRes.s = rightRes.s + "/" + (int) nums[end];
            } else {
                divRes.result = leftDiv;
                divRes.s = (int) nums[start] + "/(" + leftRes.s + ")";
            }
        }

        return divRes;
    }

    private static class Result {
        private double result;
        private String s;

        Result() {
        }

        Result(double result, String s) {
            this.result = result;
            this.s = s;
        }
    }
}
