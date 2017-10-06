package leetcode;

/**
 * Created by Aleksandr on 27/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/detect-capital
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        boolean firstCapital = false, allCapital = false, allSmall = false, allButFirstSmall = true;
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            if (i == 0) {
                if (c >= 'A' && c <= 'Z') {
                    firstCapital = true;
                    allCapital = true;
                    allSmall = false;
                    allButFirstSmall = true;
                } else {
                    firstCapital = false;
                    allCapital = false;
                    allSmall = true;
                    allButFirstSmall = true;
                }
            } else {
                if (c >= 'A' && c <= 'Z') {
                    allSmall = false;
                    allButFirstSmall = false;
                } else {
                    allCapital = false;
                }
            }
        }

        return allCapital || allSmall || (firstCapital && allButFirstSmall);
    }
}
