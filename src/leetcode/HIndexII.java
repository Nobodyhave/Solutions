package leetcode;

/**
 * Created by Aleksandr on 11/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/h-index-ii
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        final int n = citations.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            final int mid = start + (end - start) / 2;

            if (citations[mid] == n - mid) {
                return citations[mid];
            } else if (citations[mid] < n - mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return n - start;
    }
}
