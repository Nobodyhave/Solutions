package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 15/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/assign-cookies
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (s[j] >= g[i]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }

        return count;
    }
}
