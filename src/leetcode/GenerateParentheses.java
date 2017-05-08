package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 08/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/generate-parentheses
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        final List<String> result = new ArrayList<>();

        goDeeper(result, new char[n * 2], 0, 0, 0, n * 2);

        return result;
    }

    private void goDeeper(List<String> result, char[] s, int l, int r, int position, int n) {
        if (position == n) {
            if (l == r) {
                result.add(new String(s));
            }
            return;
        } else if (l > n / 2 || r > l) {
            return;
        }

        s[position] = '(';
        goDeeper(result, s, l + 1, r, position + 1, n);
        s[position] = ')';
        goDeeper(result, s, l, r + 1, position + 1, n);
    }
}
