package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aleksandr on 21/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/create-maximum-number
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k == 0 || nums1.length + nums2.length < k) {
            return new int[0];
        }

        int[] maxNum = new int[k];
        for (int len = 0; len <= k; len++) {
            if (len <= nums1.length && k - len <= nums2.length) {
                maxNum = findMaxNumber(
                        maxNum,
                        mergeNumbers(getMaximumNumber(nums1, len), getMaximumNumber(nums2, k - len)));
            }
        }

        return maxNum;
    }

    private List<Integer> getMaximumNumber(int[] nums, int len) {
        final LinkedList<Integer> result = new LinkedList<>();

        if (len == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            while (!result.isEmpty() && nums[i] > result.getLast() && Math.abs(result.size() - len) < nums.length - i) {
                result.pollLast();
            }
            if (result.size() < len) {
                result.add(nums[i]);
            }
        }

        return result;
    }

    private int[] mergeNumbers(List<Integer> num1, List<Integer> num2) {
        int i = 0, j = 0;
        final int[] result = new int[num1.size() + num2.size()];

        while (i < num1.size() || j < num2.size()) {
            if (i < num1.size() && j < num2.size()) {
                if (num1.get(i) > num2.get(j)) {
                    result[i + j] = num1.get(i);
                    i++;
                } else if(num1.get(i) < num2.get(j)) {
                    result[i + j] = num2.get(j);
                    j++;
                } else {
                    int first = i, second = j;
                    boolean isDone = false;
                    while (first < num1.size() && second < num2.size()) {
                        if(num1.get(first) > num2.get(second)) {
                            result[i + j] = num1.get(i);
                            i++;
                            isDone = true;
                            break;
                        } else if(num1.get(first) < num2.get(second)) {
                            result[i + j] = num2.get(j);
                            j++;
                            isDone = true;
                            break;
                        }
                        first++;
                        second++;
                    }
                    if(!isDone) {
                        if(num1.size() - i >= num2.size() - j) {
                            result[i + j] = num1.get(i);
                            i++;
                        } else {
                            result[i + j] = num2.get(j);
                            j++;
                        }
                    }
                }
            } else if (i < num1.size()) {
                result[i + j] = num1.get(i);
                i++;
            } else if (j < num2.size()) {
                result[i + j] = num2.get(j);
                j++;
            }
        }

        return result;
    }

    private int[] findMaxNumber(int[] num1, int[] num2) {
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] > num2[i]) {
                return num1;
            } else if (num2[i] > num1[i]) {
                return num2;
            }
        }

        return num1;
    }
}
