package leetcode;

/**
 * Created by Aleksandr on 04/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reverse-words-in-a-string-iii
 */
public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        final String[] split = s.split(" ");
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(new StringBuilder(split[i]).reverse());
            if (i != split.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
