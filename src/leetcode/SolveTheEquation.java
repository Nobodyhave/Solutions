package leetcode;

/**
 * Created by Aleksandr on 18/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/solve-the-equation
 */
public class SolveTheEquation {
    public String solveEquation(String equation) {
        if (equation == null || equation.length() == 0) {
            return "";
        }

        final String[] split = equation.split("=");
        boolean leftFirstNegative = split[0].charAt(0) == '-';
        final String[] left = leftFirstNegative ? split[0].substring(1).split("[+-]") : split[0].split("[+-]");
        boolean rightFirstNegative = split[1].charAt(0) == '-';
        final String[] right = rightFirstNegative ? split[1].substring(1).split("[+-]") : split[1].split("[+-]");


        int x = 0, cons = 0;
        if (left[0].contains("x")) {
            left[0] = left[0].replace("x", "");
            if (left[0].isEmpty()) {
                left[0] = "1";
            }
            x += leftFirstNegative ? -Integer.parseInt(left[0]) : Integer.parseInt(left[0]);
        } else {
            cons += leftFirstNegative ? -Integer.parseInt(left[0]) : Integer.parseInt(left[0]);
        }

        int leftIndex = 1;
        for (int i = 1; i < split[0].length(); i++) {
            if (split[0].charAt(i) == '+' || split[0].charAt(i) == '-') {
                if (left[leftIndex].contains("x")) {
                    left[leftIndex] = left[leftIndex].replace("x", "");
                    if (left[leftIndex].isEmpty()) {
                        left[leftIndex] = "1";
                    }
                    x += split[0].charAt(i) == '-' ? -Integer.parseInt(left[leftIndex]) : Integer.parseInt(left[leftIndex]);
                } else {
                    cons += split[0].charAt(i) == '-' ? -Integer.parseInt(left[leftIndex]) : Integer.parseInt(left[leftIndex]);
                }
                leftIndex++;
            }
        }

        if (right[0].contains("x")) {
            right[0] = right[0].replace("x", "");
            if (right[0].isEmpty()) {
                right[0] = "1";
            }
            x -= rightFirstNegative ? -Integer.parseInt(right[0]) : Integer.parseInt(right[0]);
        } else {
            cons -= rightFirstNegative ? -Integer.parseInt(right[0]) : Integer.parseInt(right[0]);
        }

        int rightIndex = 1;
        for (int i = 1; i < split[1].length(); i++) {
            if (split[1].charAt(i) == '+' || split[1].charAt(i) == '-') {
                if (right[rightIndex].contains("x")) {
                    right[rightIndex] = right[rightIndex].replace("x", "");
                    if (right[rightIndex].isEmpty()) {
                        right[rightIndex] = "1";
                    }
                    x -= split[1].charAt(i) == '-' ? -Integer.parseInt(right[rightIndex]) : Integer.parseInt(right[rightIndex]);
                } else {
                    cons -= split[1].charAt(i) == '-' ? -Integer.parseInt(right[rightIndex]) : Integer.parseInt(right[rightIndex]);
                }
                rightIndex++;
            }
        }

        if (x == 0) {
            if (cons == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + String.valueOf(-cons / x);
        }
    }
}
