package leetcode;

/**
 * Created by Aleksandr on 07/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/compare-version-numbers
 */
public class CompareVersionNumbers {
    public int compareVersion(String v1, String v2) {
        if (v1 == null || v1.isEmpty() || v2 == null || v2.isEmpty()) {
            return 0;
        }

        final String[] v1Split = v1.split("\\.");
        final String[] v2Split = v2.split("\\.");

        for (int i = 0; i < Math.min(v1Split.length, v2Split.length); i++) {
            int num1 = !v1Split[i].isEmpty() ? Integer.parseInt(v1Split[i]) : 0;
            int num2 = !v2Split[i].isEmpty() ? Integer.parseInt(v2Split[i]) : 0;

            if (num1 > num2) {
                return 1;
            } else if (num2 > num1) {
                return -1;
            }
        }

        for (int i = Math.min(v1Split.length, v2Split.length); i < Math.max(v1Split.length, v2Split.length); i++) {
            if (v1Split.length > v2Split.length) {
                int num = !v1Split[i].isEmpty() ? Integer.parseInt(v1Split[i]) : 0;
                if (num != 0) {
                    return 1;
                }
            } else {
                int num = !v2Split[i].isEmpty() ? Integer.parseInt(v2Split[i]) : 0;
                if (num != 0) {
                    return -1;
                }
            }
        }

        return 0;
    }
}
