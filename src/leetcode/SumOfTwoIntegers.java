package leetcode;

/**
 * Created by Aleksandr on 25/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/sum-of-two-integers
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
