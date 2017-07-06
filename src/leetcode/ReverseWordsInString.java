package leetcode;

/**
 * Created by Aleksandr on 06/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reverse-words-in-a-string
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        final String[] words = s.split("\\s");
        final StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() != 0) {
                sb.append(words[i]).append(" ");
            }
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}
