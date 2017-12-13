package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Aleksandr on 30/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/asteroid-collision
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[0];
        }

        final Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        Integer current = null;
        while (i < asteroids.length || current != null) {
            if (current == null) {
                current = asteroids[i++];
            }

            if (deque.isEmpty()) {
                deque.addFirst(current);
                current = null;
            } else {
                if (deque.peek() < 0) {
                    deque.addFirst(current);
                    current = null;
                } else if (deque.peek() > 0) {
                    if (current < 0) {
                        if (Math.abs(deque.peek()) > Math.abs(current)) {
                            current = null;
                        } else if (Math.abs(deque.peek()) < Math.abs(current)) {
                            deque.pollFirst();
                        } else {
                            deque.pollFirst();
                            current = null;
                        }
                    } else if (current > 0) {
                        deque.addFirst(current);
                        current = null;
                    } else {
                        if (Math.abs(deque.peek()) > Math.abs(current)) {
                            current = null;
                        } else if (Math.abs(deque.peek()) < Math.abs(current)) {
                            deque.pollFirst();
                        } else {
                            deque.pollFirst();
                            current = null;
                        }
                    }
                } else {
                    if (current < 0) {
                        if (Math.abs(deque.peek()) > Math.abs(current)) {
                            current = null;
                        } else if (Math.abs(deque.peek()) < Math.abs(current)) {
                            deque.pollFirst();
                        } else {
                            deque.pollFirst();
                            current = null;
                        }
                    } else {
                        deque.addFirst(current);
                        current = null;
                    }
                }
            }
        }

        final int[] result = new int[deque.size()];
        for (i = deque.size() - 1; i >= 0; i--) {
            result[i] = deque.pollFirst();
        }

        return result;
    }
}
