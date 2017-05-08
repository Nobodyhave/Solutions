package leetcode;

/**
 * Created by Aleksandr on 05/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-common-prefix
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();
        int index = 0;
        outer:
        while (true) {
            if (index == strs[0].length()) {
                break;
            }
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() == index || strs[i].charAt(index) != c) {
                    break outer;
                }
            }
            sb.append(c);
            index++;
        }

        return sb.toString();
    }
}
