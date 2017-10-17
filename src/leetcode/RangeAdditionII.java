package leetcode;

/**
 * Created by Aleksandr on 09/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/range-addition-ii
 */
public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null) {
            return 0;
        }

        int mR = m, mC = n;
        for (int i = 0; i < ops.length; i++) {
            mR = Math.min(mR, ops[i][0]);
            mC = Math.min(mC, ops[i][1]);
        }

        return mR * mC;
    }
}
