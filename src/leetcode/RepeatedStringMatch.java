package leetcode;

/**
 * Created by Aleksandr on 01/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/repeated-string-match
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        if (A.contains(B)) {
            return 1;
        } else if (A.length() >= B.length()) {
            if ((A + A).contains(B)) {
                return 2;
            } else {
                return -1;
            }
        } else if (!B.contains(A)) {
            return -1;
        }

        int start = B.indexOf(A);
        if (!A.endsWith(B.substring(0, start))) {
            return -1;
        }

        int end = B.lastIndexOf(A);
        if (!A.startsWith(B.substring(end + A.length()))) {
            return -1;
        }

        int count = start != 0 ? 1 : 0;
        int endIndex = -1;
        for (int i = start; i <= end; i += A.length()) {
            count++;
            for (int j = 0; j < A.length(); j++) {
                endIndex = i + j;
                if (A.charAt(j) != B.charAt(i + j)) {
                    return -1;
                }
            }
        }

        if (!A.startsWith(B.substring(endIndex + 1))) {
            return -1;
        }
        count += endIndex + 1 != B.length() ? 1 : 0;

        return count;
    }
}
