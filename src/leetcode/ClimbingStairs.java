package leetcode;

/**
 * Created by Aleksandr on 29/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/climbing-stairs
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }

        int first = 1, second = 1;
        for (int i = 2; i <= n; i++) {
            int next = first + second;
            first = second;
            second = next;
        }

        return second;
    }
}
