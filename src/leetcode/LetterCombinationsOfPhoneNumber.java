package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 08/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 */
public class LetterCombinationsOfPhoneNumber {
    private static String[] KEYBOARD = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        final List<String> result = new ArrayList<>();

        goDeeper(result, digits, new StringBuilder(), 0);

        return result;
    }

    private void goDeeper(List<String> result, String digits, StringBuilder sb, int depth) {
        if (depth == digits.length()) {
            if (sb.length() > 0) {
                result.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < KEYBOARD[digits.charAt(depth) - '0'].length(); i++) {
            sb.append(KEYBOARD[digits.charAt(depth) - '0'].charAt(i));
            goDeeper(result, digits, sb, depth + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
