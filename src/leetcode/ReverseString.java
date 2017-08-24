package leetcode;

/**
 * Created by Aleksandr on 23/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reverse-string
 */
public class ReverseString {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
