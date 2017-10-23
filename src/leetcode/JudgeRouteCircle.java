package leetcode;

/**
 * Created by Aleksandr on 23/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/judge-route-circle
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return false;
        }

        int hor = 0, vert = 0;
        for (int i = 0; i < moves.length(); i++) {
            final char c = moves.charAt(i);
            if (c == 'L') {
                hor--;
            } else if (c == 'R') {
                hor++;
            } else if (c == 'U') {
                vert++;
            } else {
                vert--;
            }
        }

        return hor == 0 && vert == 0;
    }
}
