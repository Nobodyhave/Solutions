package leetcode;

/**
 * Created by Aleksandr on 26/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/maximum-swap/description/
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        if (num < 0) {
            return 0;
        } else if (num < 10) {
            return num;
        }

        final StringBuilder sb = new StringBuilder(String.valueOf(num));
        maximize(sb, 0);

        return Integer.parseInt(sb.toString());
    }

    private void maximize(StringBuilder sb, int start) {
        if (start == sb.length() - 1) {
            return;
        }

        final int maxIndex = findMax(sb, start + 1);
        if (sb.charAt(start) >= sb.charAt(maxIndex)) {
            maximize(sb, start + 1);
        } else {
            swap(sb, start, maxIndex);
        }
    }

    private void swap(StringBuilder sb, int i, int j) {
        final char c = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, c);
    }

    private int findMax(StringBuilder sb, int start) {
        char max = sb.charAt(start);
        int maxIndex = start;
        for (int i = start; i < sb.length(); i++) {
            if (sb.charAt(i) >= max) {
                max = sb.charAt(i);
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
