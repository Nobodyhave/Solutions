package leetcode;

/**
 * Created by Aleksandr on 30/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/elimination-game
 */
public class EliminationGame {
    public int lastRemaining(int n) {
        int start = 1, step = 1, length = n;
        boolean fromStart = true;
        while (length != 1) {
            if (length % 2 == 0) {
                length -= length / 2;
                if (fromStart) {
                    start += step;
                }
            } else {
                length -= (length + 1) / 2;
                start += step;
            }
            fromStart = !fromStart;
            step *= 2;
        }

        return start;
    }
}
