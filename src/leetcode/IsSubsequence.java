package leetcode;

/**
 * Created by Aleksandr on 30/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/is-subsequence
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || (t.isEmpty() && !s.isEmpty())) {
            return false;
        } else if (s.isEmpty()) {
            return true;
        }

        int start = 0;
        for (int i = 0; i < t.length() && start < s.length(); i++) {
            if (t.charAt(i) == s.charAt(start)) {
                start++;
            }
        }

        return start == s.length();
    }
}
