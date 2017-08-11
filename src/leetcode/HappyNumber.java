package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksandr on 12/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/happy-number
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        final Set<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);

            int num = 0;
            while (n > 0) {
                int r = n % 10;
                num += r * r;
                n /= 10;
            }
            n = num;
        }

        return n == 1;
    }
}
