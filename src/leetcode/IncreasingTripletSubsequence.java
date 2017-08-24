package leetcode;

/**
 * Created by Aleksandr on 23/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/increasing-triplet-subsequence
 */
public class IncreasingTripletSubsequence {
    public boolean isSelfCrossing(int[] x) {
        if(x == null) {
            return false;
        }

        if (x.length <= 3) {
            return false;
        }
        int i = 2;
        // keep spiraling outward
        while (i < x.length && x[i] > x[i - 2]) {
            i++;
        }
        if (i >= x.length) {
            return false;
        }
        // transition from spiraling outward to spiraling inward
        if ((i >= 4 && x[i] >= x[i - 2] - x[i - 4]) ||
                (i == 3 && x[i] == x[i - 2])) {
            x[i - 1] -= x[i - 3];
        }
        i++;
        // keep spiraling inward
        while (i < x.length) {
            if (x[i] >= x[i - 2]) {
                return true;
            }
            i++;
        }
        return false;
    }
}
