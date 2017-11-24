package interviewbit;

import java.util.ArrayList;

/**
 * Created by Aleksandr on 24/11/2017.
 * Project Solutions
 * <p>
 * https://www.interviewbit.com/problems/inversions/
 */
public class Inversions {
    public int countInversions(ArrayList<Integer> a) {
        if (a == null || a.size() < 2) {
            return 0;
        }

        return sort(a, new int[a.size()], 0, a.size() - 1);
    }

    private int sort(ArrayList<Integer> a, int[] aux, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int count = 0;
        final int mid = left + (right - left) / 2;
        count += sort(a, aux, left, mid);
        count += sort(a, aux, mid + 1, right);
        count += merge(a, aux, left, mid, right);

        return count;
    }

    private int merge(ArrayList<Integer> a, int[] aux, int left, int mid, int right) {
        for (int k = left; k <= right; k++) {
            aux[k] = a.get(k);
        }

        int count = 0;
        for (int i = left, j = mid + 1, k = left; k <= right; k++) {
            if (i > mid) {
                a.set(k, aux[j++]);
            } else if (j > right) {
                a.set(k, aux[i++]);
            } else if (aux[i] <= aux[j]) {
                a.set(k, aux[i++]);
            } else {
                count += mid - i + 1;
                a.set(k, aux[j++]);
            }
        }

        return count;
    }
}
