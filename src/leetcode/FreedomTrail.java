package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 28/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/freedom-trail
 */
public class FreedomTrail {
    private final Map<Key, Integer> CACHE = new HashMap<>();

    public int findRotateSteps(String ring, String key) {
        if (ring == null || key == null || ring.length() == 0 || key.length() == 0) {
            return 0;
        }

        return dfs(ring.toCharArray(), key.toCharArray(), 0, 0);
    }

    private int dfs(char[] ring, char[] key, int ringIndex, int keyIndex) {
        Integer val = CACHE.get(new Key(ringIndex, key.length - keyIndex));
        if (val != null) {
            return val;
        }

        int i = 0;
        while (keyIndex + i < key.length && ring[ringIndex] == key[keyIndex + i]) {
            i++;
        }

        if (keyIndex + i == key.length) {
            CACHE.put(new Key(ringIndex, i), i);
            return i;
        }

        int leftLimit = (ring.length >> 1) - ((ring.length & 1) == 0 ? 1 : 0);
        int rightLimit = (ring.length >> 1);

        int leftTurn = 1, leftCheck = -1;
        while (leftTurn <= leftLimit) {
            final int index = (ringIndex - leftTurn + ring.length) % ring.length;
            if (ring[index] == key[keyIndex + i]) {
                leftCheck = dfs(ring, key, index, keyIndex + i);
                break;
            }
            leftTurn++;
        }

        int rightTurn = 1, rightCheck = -1;
        while (rightTurn <= rightLimit) {
            final int index = (ringIndex + rightTurn) % ring.length;
            if (ring[index] == key[keyIndex + i]) {
                rightCheck = dfs(ring, key, index, keyIndex + i);
                break;
            }
            rightTurn++;
        }

        final int result = i + Math.min(
                ((leftCheck != -1) ? leftTurn + leftCheck : Integer.MAX_VALUE),
                ((rightCheck != -1) ? rightTurn + rightCheck : Integer.MAX_VALUE));
        CACHE.put(new Key(ringIndex, key.length - keyIndex), result);

        return result;
    }

    private static class Key {
        private int ringIndex;
        private int lettersLeft;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (ringIndex != key.ringIndex) return false;
            return lettersLeft == key.lettersLeft;
        }

        @Override
        public int hashCode() {
            int result = ringIndex;
            result = 31 * result + lettersLeft;
            return result;
        }

        Key(int ringIndex, int lettersLeft) {
            this.ringIndex = ringIndex;
            this.lettersLeft = lettersLeft;
        }
    }
}
