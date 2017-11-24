package interviewbit;

import java.util.ArrayList;

/**
 * Created by Aleksandr on 24/11/2017.
 * Project Solutions
 * <p>
 * https://www.interviewbit.com/problems/prettyprint/
 */
public class PrettyPrint {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int N = 2 * A - 1;
        final int[][] temp = new int[N][N];
        for (int a = A; a >= 1; a--) {
            for (int i = 0; i < 2 * a - 1; i++) {
                temp[A - a][A - a + i] = a;
                temp[A - a + i][A - a] = a;
                temp[N - (A - a) - 1][A - a + i] = a;
                temp[A - a + i][N - (A - a) - 1] = a;
            }
        }

        for (int i = 0; i < N; i++) {
            final ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                list.add(temp[i][j]);
            }
            result.add(list);
        }

        return result;
    }
}
