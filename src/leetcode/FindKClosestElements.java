package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 23/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/find-k-closest-elements
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        final int index = Arrays.binarySearch(arr, x);
        final Deque<Integer> deque = new ArrayDeque<>();

        int l, r;
        if (index >= 0) {
            deque.addFirst(arr[index]);
            k--;
            l = index - 1;
            r = index + 1;
        } else {
            l = -(index + 1) - 1;
            r = -(index + 1);
        }

        while (k > 0) {
            if (l >= 0 && r < arr.length) {
                if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                    deque.addFirst(arr[l--]);
                } else {
                    deque.addLast(arr[r++]);
                }
            } else if (l >= 0) {
                deque.addFirst(arr[l--]);
            } else if (r < arr.length) {
                deque.addLast(arr[r++]);
            }
            k--;
        }

        return new ArrayList<>(deque);
    }
}
