package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 21/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/magical-string
 */
public class MagicalString {
    public int magicalString(int n) {
        if (n < 1) {
            return 0;
        } else if (n < 4) {
            return 1;
        }

        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);

        int i = 2, count = 1;
        n -= 3;
        while (true) {
            int last = list.get(list.size() - 1);
            for (int j = 0; j < list.get(i); j++) {
                if (last == 1) {
                    list.add(2);
                } else {
                    count++;
                    list.add(1);
                }
                n--;
                if (n == 0) {
                    return count;
                }
            }
            i++;
        }
    }
}
