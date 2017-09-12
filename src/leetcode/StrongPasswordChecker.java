package leetcode;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/strong-password-checker
 */
public class StrongPasswordChecker {
    public int strongPasswordChecker(String s) {
        int res = 0, a = 1, A = 1, d = 1;
        final char[] carr = s.toCharArray();
        final int[] arr = new int[carr.length];

        for (int i = 0; i < arr.length; ) {
            if (Character.isLowerCase(carr[i])) {
                a = 0;
            }
            if (Character.isUpperCase(carr[i])) {
                A = 0;
            }
            if (Character.isDigit(carr[i])) {
                d = 0;
            }

            int j = i;
            while (i < carr.length && carr[i] == carr[j]) {
                i++;
            }
            arr[j] = i - j;
        }

        final int totalMissing = (a + A + d);

        if (arr.length < 6) {
            res += totalMissing + Math.max(0, 6 - (arr.length + totalMissing));

        } else {
            int overLength = Math.max(arr.length - 20, 0), leftover = 0;
            res += overLength;

            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < arr.length && overLength > 0; i++) {
                    if (arr[i] < 3 || arr[i] % 3 != (k - 1)) continue;
                    arr[i] -= Math.min(overLength, k);
                    overLength -= k;
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 3 && overLength > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= overLength;
                    overLength -= need;
                }

                if (arr[i] >= 3) {
                    leftover += arr[i] / 3;
                }
            }

            res += Math.max(totalMissing, leftover);
        }

        return res;
    }
}
