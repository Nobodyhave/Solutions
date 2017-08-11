package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 11/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/expression-add-operators/description/
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        final List<String> variants = new ArrayList<>();

        if(num == null || num.isEmpty()) {
            return variants;
        } else if(num.length() == 1) {
            variants.add(num);
            return variants;
        }

        goDeeper(num, target, variants, "", 0, 0, 0);

        return variants;
    }

    private void goDeeper(String num, long target, List<String> variants, String expression, int start, long result, long multiplied) {
        if(start >= num.length()) {
            if(target == result) {
                variants.add(expression);
            }

            return;
        }

        for(int i = start; i < num.length(); i++) {
            if(i != start && num.charAt(start) == '0') {
                break;
            }
            long current = Long.parseLong(num.substring(start, i + 1));

            if(start == 0) {
                goDeeper(num, target, variants, expression + current, i + 1, current, current);
            } else {
                goDeeper(num, target, variants, expression + "+" + current, i + 1, result + current, current);
                goDeeper(num, target, variants, expression + "-" + current, i + 1, result - current, -current);
                goDeeper(num, target, variants, expression + "*" + current, i + 1, result - multiplied + multiplied*current, multiplied*current);
            }
        }
    }
}
