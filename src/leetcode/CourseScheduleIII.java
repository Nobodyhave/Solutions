package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Aleksandr on 17/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/course-schedule-iii
 */
public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length == 0 || courses[0] == null || courses[0].length == 0) {
            return 0;
        }

        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));

        int time = 0;
        final PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int[] course : courses) {
            int duration = course[0];
            int endDate = course[1];

            time += duration;
            pq.add(duration);
            if (time > endDate) {
                time -= pq.poll();
            }
        }

        return pq.size();
    }
}
