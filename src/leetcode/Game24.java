package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 30/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/24-game
 */
public class Game24 {
    public boolean judgePoint24(int[] nums) {
        final List<Number> numbers = new ArrayList<>();

        for (int num : nums) {
            numbers.add(new Number(num, 1));
        }

        return dfs(numbers);
    }

    private boolean dfs(List<Number> nums) {
        if (nums.size() == 1) {
            final Number number = nums.get(0);
            final int num = number.num;
            final int den = number.den;

            return den != 0 && num * den >= 0 && (num / den) * den == num && num / den == 24;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                final Number num1 = nums.get(i);
                final Number num2 = nums.get(j);

                final Number[] ops = new Number[6];
                ops[0] = num1.add(num2);
                ops[1] = num1.subtract(num2);
                ops[2] = num2.subtract(num1);
                ops[3] = num1.multiply(num2);
                ops[4] = num1.divide(num2);
                ops[5] = num2.divide(num1);

                nums.remove(i);
                nums.remove(j);
                for (Number op : ops) {
                    nums.add(op);
                    if (dfs(nums)) {
                        return true;
                    }
                    nums.remove(nums.size() - 1);
                }

                nums.add(j, num2);
                nums.add(i, num1);
            }
        }

        return false;
    }

    private static class Number {
        private int num;
        private int den;

        Number(int num, int den) {
            this.num = num;
            this.den = den;
        }

        Number add(Number o) {
            final int n = num * o.den + o.num * den;
            final int d = den * o.den;

            return new Number(n, d);
        }

        Number subtract(Number o) {
            final int n = num * o.den - o.num * den;
            final int d = den * o.den;

            return new Number(n, d);
        }

        Number multiply(Number o) {
            final int n = num * o.num;
            final int d = den * o.den;

            return new Number(n, d);
        }

        Number divide(Number o) {
            final int n = num * o.den;
            final int d = o.num * den;

            return new Number(n, d);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Number number = (Number) o;

            return num == number.num && den == number.den;
        }

        @Override
        public int hashCode() {
            int result = num;
            result = 31 * result + den;
            return result;
        }

        @Override
        public String toString() {
            return num + "/" + den;
        }
    }
}
