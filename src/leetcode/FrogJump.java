package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/frog-jump
 */
public class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length < 2) {
            return false;
        } else if (stones[1] != 1) {
            return false;
        } else if (stones.length == 2) {
            return true;
        } else {
            final Set<Integer> set = new HashSet<>();
            for (int i = 0; i < stones.length; i++) {
                if (i > 3 && stones[i] > stones[i - 1] * 2) {
                    return false;
                }
                set.add(stones[i]);
            }
            return goDeeper(set, stones[stones.length - 1], 1, 1);
        }
    }

    private boolean goDeeper(Set<Integer> stones, int last, int jump, int dist) {
        if (dist == last) {
            return true;
        } else if (dist > last || dist < 0) {
            return false;
        } else {
            if (stones.contains(dist + jump + 1) && goDeeper(stones, last, jump + 1, dist + jump + 1)) {
                return true;
            }
            if (stones.contains(dist + jump) && goDeeper(stones, last, jump, dist + jump)) {
                return true;
            }
            if (jump > 1 && stones.contains(dist + jump - 1) && goDeeper(stones, last, jump - 1, dist + jump - 1)) {
                return true;
            }

            return false;
        }
    }
}
