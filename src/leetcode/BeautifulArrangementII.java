package leetcode;

/**
 * Created by Aleksandr on 25/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/beautiful-arrangement-ii
 */
public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        final int[] result = new int[n];

        int start = 0, end = k, lStart = k + 1, i = 0;
        while (start < end) {
            result[i++] = ++start;
            result[i++] = end-- + 1;
        }

        if (start == end) {
            result[i++] = start + 1;
        }

        while (i < n) {
            result[i++] = ++lStart;
        }

        return result;
    }
}
