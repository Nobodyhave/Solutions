package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/queue-reconstruction-by-height
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length < 2) {
            return people;
        }

        Arrays.sort(people, (a1, a2) -> {
            int result = Integer.compare(a2[0], a1[0]);
            if (result == 0) {
                result = Integer.compare(a1[1], a2[1]);
            }

            return result;
        });

        final ArrayList<int[]> result = new ArrayList<>(people.length);
        for (int[] p : people) {
            result.add(p[2], p);
        }

        return result.toArray(people);
    }
}
