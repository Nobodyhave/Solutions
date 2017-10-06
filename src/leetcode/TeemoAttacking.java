package leetcode;

/**
 * Created by Aleksandr on 25/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/teemo-attacking
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration <= 0) {
            return 0;
        }

        int poisonedUpTo = 0, poisonedDuration = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            final int time = timeSeries[i];
            if (time <= poisonedUpTo) {
                poisonedDuration += (time + duration) - poisonedUpTo;
            } else {
                poisonedDuration += duration;
            }

            poisonedUpTo = Math.max(poisonedUpTo, time + duration);
        }

        return poisonedDuration;
    }
}
