package leetcode;

/**
 * Created by Aleksandr on 05/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/find-the-closest-palindrome
 */
public class FindClosestPalindrome {
    private long ans = 0, diff = Long.MAX_VALUE, n = 0;

    public String nearestPalindromic(String n) {
        this.n = Long.parseLong(n);
        diff = Long.MAX_VALUE;
        final long leftHalf = Long.parseLong(n.substring(0, (n.length() + 1) / 2));
        concat(leftHalf - 1);
        concat((leftHalf - 1) * 10 + 9); // Handle 1, 1000, 100000, etc.
        concat(leftHalf);
        concat(leftHalf + 1);
        concat((leftHalf + 1) / 10); // Handle 9, 999, 99999, etc.
        return "" + ans;
    }

    private void update(String val) {
        final long tmp = Long.parseLong(val);
        if (tmp == n) return;
        if (Math.abs(tmp - n) < diff || (Math.abs(tmp - n) == diff && tmp < ans)) {
            ans = tmp;
            diff = Math.abs(tmp - n);
        }
    }

    private void concat(long leftHalf) {
        String s = "" + leftHalf, rs = new StringBuilder(s).reverse().toString();
        update(s + rs); // abc -> abccba
        update(s + rs.substring(1)); // abc -> abcba
    }
}
