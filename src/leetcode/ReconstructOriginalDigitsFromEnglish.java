package leetcode;

/**
 * Created by Aleksandr on 08/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reconstruct-original-digits-from-english
 */
public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        final int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        final int[] numCount = new int[10];

        numCount[0] = count['z' - 'a'];
        numCount[2] = count['w' - 'a'];
        numCount[6] = count['x' - 'a'];
        numCount[8] = count['g' - 'a'];
        numCount[4] = count['u' - 'a'];
        numCount[3] = count['h' - 'a'] - numCount[8];
        numCount[7] = count['s' - 'a'] - numCount[6];
        numCount[5] = count['v' - 'a'] - numCount[7];
        numCount[9] = count['i' - 'a'] - numCount[5] - numCount[6] - numCount[8];
        numCount[1] = count['n' - 'a'] - numCount[7] - 2 * numCount[9];

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numCount.length; i++) {
            for (int j = 0; j < numCount[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
