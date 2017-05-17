package leetcode;

/**
 * Created by Aleksandr on 11/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/count-and-say
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        } else if (n == 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder("1");


        for (int i = 2; i <= n; i++) {
            final StringBuilder seq = new StringBuilder();

            char c = sb.charAt(0);
            int count = 1;
            for (int j = 1; j < sb.length(); j++) {
                if (sb.charAt(j) == c) {
                    count++;
                } else {
                    seq.append(count).append(c);
                    count = 1;
                    c = sb.charAt(j);
                }
            }
            seq.append(count).append(c);

            sb = seq;
        }

        return sb.toString();
    }
}
