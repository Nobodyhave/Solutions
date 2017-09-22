package leetcode;

/**
 * Created by Aleksandr on 15/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/repeated-substring-pattern
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        final String concatenation = s + s;

        return concatenation.substring(1, concatenation.length() - 1).contains(s);
    }
}
