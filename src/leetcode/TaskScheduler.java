package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 16/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/task-scheduler
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        final int[] counts = new int[26];
        for (char t : tasks) {
            counts[t - 'A']++;
        }

        Arrays.sort(counts);

        int i = 25;
        while (i >= 0 && counts[i] == counts[25]) {
            i--;
        }

        return Math.max(tasks.length, (counts[25] - 1) * (n + 1) + 25 - i);
    }
}
