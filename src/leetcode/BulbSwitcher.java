package leetcode;

/**
 * Created by Aleksandr on 18/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/bulb-switcher
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        if (n == 0) {
            return 0;
        }

        int i = 1;
        while (i * i <= n) {
            i++;
        }

        if (i * i > n) {
            i--;
        }

        return i;
    }
}
