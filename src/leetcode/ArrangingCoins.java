package leetcode;

/**
 * Created by Aleksandr on 12/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/arranging-coins
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if(n < 1) {
            return 0;
        }
        long start = 1, end = 70000, max = 0;
        while(start <= end) {
            long mid = start + (end - start) / 2;

            long tNum = calculateTriangularNumber(mid);
            if(tNum > n) {
                end = mid - 1;
            } else if(tNum < n) {
                max = Math.max(mid, max);
                start = mid + 1;
            } else {
                return (int)mid;
            }
        }

        return (int)max;
    }

    private long calculateTriangularNumber(long n) {
        return n*(n + 1) / 2;
    }
}
