package leetcode;

/**
 * Created by Aleksandr on 19/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/add-digits
 */
public class AddDigits {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
