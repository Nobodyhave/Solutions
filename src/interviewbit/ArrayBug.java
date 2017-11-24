package interviewbit;

import java.util.ArrayList;

/**
 * Created by Aleksandr on 24/11/2017.
 * Project Solutions
 * <p>
 * https://www.interviewbit.com/problems/arraybug/
 */
public class ArrayBug {
    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            ret.add(A.get((i + B) % A.size()));
        }
        return ret;
    }
}
