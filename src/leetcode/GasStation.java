package leetcode;

/**
 * Created by Aleksandr on 29/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/gas-station
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return -1;
        }

        for (int start = 0; start < gas.length; start++) {
            int fuel = 0;
            boolean isPossible = true;
            for (int current = 0; current < gas.length; current++) {
                fuel += gas[(start + current) % gas.length];
                fuel -= cost[(start + current) % gas.length];

                if (fuel < 0) {
                    isPossible = false;
                    start += current;
                    break;
                }
            }

            if (isPossible) {
                return start;
            }
        }

        return -1;
    }
}
