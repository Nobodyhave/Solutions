package leetcode;

/**
 * Created by Aleksandr on 25/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/guess-number-higher-or-lower
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        if (n < 1) {
            return 0;
        }

        int start = 1, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (guess(mid) < 0) {
                end = mid - 1;
            } else if (guess(mid) > 0) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return 0;
    }


    // Fake method
    private int guess(int num) {
        return -1;
    }
}
