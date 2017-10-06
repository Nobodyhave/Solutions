package leetcode;

/**
 * Created by Aleksandr on 04/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/student-attendance-record-i
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int countA = 0, countL = 0;

        for (int i = 0; i < s.length(); i++) {
            final char cur = s.charAt(i);

            if (cur == 'A') {
                countA++;
                countL = 0;
            } else if (cur == 'L') {
                countL++;
            } else {
                countL = 0;
            }

            if (countA >= 2 || countL > 2) {
                return false;
            }
        }

        return true;
    }
}
