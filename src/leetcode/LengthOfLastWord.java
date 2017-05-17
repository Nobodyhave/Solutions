package leetcode;

/**
 * Created by Aleksandr on 17/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/length-of-last-word
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.trim();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return count;
            } else {
                count++;
            }
        }

        return count;
    }
}
