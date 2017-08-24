package leetcode;

/**
 * Created by Aleksandr on 23/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/counting-bits
 */
public class CountingBits {
    public int[] countBits(int num) {
        if (num < 1) {
            return new int[0];
        }

        final int[] count = new int[num];
        for (int i = 1; i <= num; i++) {
            count[i - 1] = bitCount(i);
        }

        return count;
    }

    private int bitCount(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n-1);
            count++;
        }

        return count;
    }
}
