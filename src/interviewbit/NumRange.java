package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aleksandr on 23/11/2017.
 * Project Solutions
 * <p>
 * https://www.interviewbit.com/problems/numrange/
 */
public class NumRange {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90));
        System.out.println(new NumRange().numRange(list, 99, 269));
    }

    public int numRange(ArrayList<Integer> A, int b, int c) {
        if (A == null || A.size() == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int sum = 0;
        int count = 0;

        while (i < A.size()) {
            sum = sum + A.get(j);
            if ((sum >= b) && (sum <= c)) {
                count++;
                j++;
            } else if (sum < b) {
                j++;
            } else if (sum > c) {
                i++;
                j = i;
                sum = 0;
            }
            if (j == A.size()) {
                sum = 0;
                i++;
                j = i;
            }
        }

        return count;
    }
}
