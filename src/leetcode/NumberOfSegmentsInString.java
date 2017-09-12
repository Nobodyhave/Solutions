package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 12/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/number-of-segments-in-a-string
 */
public class NumberOfSegmentsInString {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else {
            return (int) Arrays.stream(s.split("\\s+")).filter(s1 -> !s1.isEmpty()).count();
        }
    }
}
