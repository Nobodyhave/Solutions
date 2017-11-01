package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksandr on 30/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/next-closest-time
 */
public class NextClosestTime {
    private final int minutesInDay = 24 * 60;

    public String nextClosestTime(String time) {
        final Set<Integer> set = new HashSet<>();
        int minutes = 0;

        final int hFirst = time.charAt(0) - '0';
        set.add(hFirst);
        minutes += hFirst * 10 * 60;

        final int hSecond = time.charAt(1) - '0';
        set.add(hSecond);
        minutes += hSecond * 60;

        final int mFirst = time.charAt(3) - '0';
        set.add(mFirst);
        minutes += mFirst * 10;

        final int mSecond = time.charAt(4) - '0';
        set.add(mSecond);
        minutes += mSecond;

        final int minDiff = dfs(set, new int[4], minutes, 0);

        minutes = (minutes + minDiff) % minutesInDay;

        final StringBuilder sb = new StringBuilder();
        sb.append(minutes / 600);
        minutes %= 600;
        sb.append(minutes / 60);
        minutes %= 60;
        sb.append(":");
        sb.append(minutes / 10);
        minutes %= 10;
        sb.append(minutes);

        return sb.toString();
    }

    private int dfs(Set<Integer> set, int[] digits, int minutes, int start) {
        if (start == digits.length) {
            final int time = digits[0] * 10 * 60 + digits[1] * 60 + digits[2] * 10 + digits[3];

            if (time > minutes) {
                return time - minutes;
            } else {
                return minutesInDay - (minutes - time);
            }

        }

        int min = Integer.MAX_VALUE;
        for (int digit : set) {
            if (!isValidTime(digits)) {
                continue;
            }
            int old = digits[start];
            digits[start] = digit;
            min = Math.min(min, dfs(set, digits, minutes, start + 1));
            digits[start] = old;
        }

        return min;
    }

    private boolean isValidTime(int[] digits) {
        if ((digits[0] == 2 && digits[1] > 3) || (digits[0] > 2) || (digits[2] > 5)) {
            return false;
        }

        return true;
    }
}
