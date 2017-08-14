package leetcode;

/**
 * Created by Aleksandr on 14/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/nim-game
 */
public class NimGame {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
