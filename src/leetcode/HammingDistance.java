package leetcode;

/**
 * Created by Aleksandr on 18/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/hamming-distance
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if (((x ^ y) & mask) != 0) {
                count++;
            }
        }

        return count;
    }
}
