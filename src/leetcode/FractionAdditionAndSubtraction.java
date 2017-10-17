package leetcode;

/**
 * Created by Aleksandr on 10/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/fraction-addition-and-subtraction
 */
public class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }

        String[] split;
        boolean firstNegative = false;
        if (expression.charAt(0) == '-') {
            firstNegative = true;
            split = expression.substring(1).split("[+-]");
        } else {
            split = expression.split("[+-]");
        }

        int fIndex = 0;
        String[] fSplit = split[fIndex].split("/");
        int numerator = Integer.parseInt(fSplit[0]) * (firstNegative ? -1 : 1);
        int denominator = Integer.parseInt(fSplit[1]);
        fIndex = 1;
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '-') {
                fSplit = split[fIndex].split("/");
                int nextNumerator = Integer.parseInt(fSplit[0]);
                int nextDenominator = Integer.parseInt(fSplit[1]);
                numerator = numerator * nextDenominator - nextNumerator * denominator;
                denominator = denominator * nextDenominator;

                int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
                numerator /= gcd;
                denominator /= gcd;
                fIndex++;
            } else if (expression.charAt(i) == '+') {
                fSplit = split[fIndex].split("/");
                int nextNumerator = Integer.parseInt(fSplit[0]);
                int nextDenominator = Integer.parseInt(fSplit[1]);
                numerator = numerator * nextDenominator + nextNumerator * denominator;
                denominator = denominator * nextDenominator;

                int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
                numerator /= gcd;
                denominator /= gcd;
                fIndex++;
            }
        }

        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
