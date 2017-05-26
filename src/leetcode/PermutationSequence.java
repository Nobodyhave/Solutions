package leetcode;

/**
 * Created by Aleksandr on 26/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/permutation-sequence
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        final StringBuilder digits = new StringBuilder();
        final StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            digits.append(i);
        }

        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        goDeeper(result, digits, fact, k, n);

        return result.toString();
    }

    private static void goDeeper(StringBuilder result, StringBuilder digits, int factorial, int k, int n) {
        if (n == 0) {
            return;
        }

        int index = (k - 1) / (factorial / n);
        result.append(digits.charAt(index));
        digits.deleteCharAt(index);
        goDeeper(result, digits, factorial / n, k - index * (factorial / n), n - 1);
    }
}
