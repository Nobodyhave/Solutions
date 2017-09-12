package leetcode;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/arithmetic-slices
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        final int[] diff = new int[A.length - 1];

        for (int i = 1; i < A.length; i++) {
            diff[i - 1] = A[i] - A[i - 1];
        }

        int series = 0;
        int count = 1;
        for (int i = 1; i < diff.length; i++) {
            if (diff[i - 1] == diff[i]) {
                count++;
            } else {
                series += getCount(count + 1);
                count = 1;
            }
        }
        series += getCount(count + 1);

        return series;
    }

    private int getCount(int n) {
        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            count += i + 1;
        }

        return count;
    }
}
