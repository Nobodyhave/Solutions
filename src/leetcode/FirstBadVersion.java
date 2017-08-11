package leetcode;

/**
 * Created by Aleksandr on 11/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/first-bad-version/description/
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1, end = n, bad = n;
        while (start <= end) {
            final int mid = start + (end - start) / 2;

            if (isBadVersion(mid)) {
                end = mid - 1;
                bad = Math.min(bad, mid);
            } else {
                start = mid + 1;
            }
        }

        return bad;
    }

    private boolean isBadVersion(int version) {
        return true;
    }

}
