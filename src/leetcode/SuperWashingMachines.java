package leetcode;

/**
 * Created by Aleksandr on 29/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/super-washing-machines/discuss/
 */
public class SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length < 2) {
            return 0;
        }

        int totalLoad = 0;
        for (int load : machines) {
            totalLoad += load;
        }

        if (totalLoad % machines.length != 0) {
            return -1;
        }

        final int average = totalLoad / machines.length;

        int max = 0, count = 0;
        for (int load : machines) {
            count += load - average;
            max = Math.max(max, Math.max(Math.abs(count), load - average));
        }

        return max;
    }
}
