package leetcode;

/**
 * Created by Aleksandr on 03/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/count-binary-substrings
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            char prev = s.charAt(i - 1);
            char cur = s.charAt(i);

            if (prev == '0' && cur == '1') {
                int start = i - 1, end = i;
                while (start >= 0 && end < s.length() && s.charAt(start) == '0' && s.charAt(end) == '1') {
                    start--;
                    end++;
                }
                count += (end - start - 1) / 2;
            } else if (prev == '1' && cur == '0') {
                int start = i - 1, end = i;
                while (start >= 0 && end < s.length() && s.charAt(start) == '1' && s.charAt(end) == '0') {
                    start--;
                    end++;
                }
                count += (end - start - 1) / 2;
            }
        }

        return count;
    }
}
