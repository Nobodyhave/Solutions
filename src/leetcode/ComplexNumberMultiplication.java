package leetcode;

/**
 * Created by Aleksandr on 03/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/complex-number-multiplication
 */
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return "";
        }

        return new ComplexNumber(a).multiply(new ComplexNumber(b)).toString();
    }

    private static class ComplexNumber {
        private int real;
        private int imaginary;

        ComplexNumber(String s) {
            real = Integer.parseInt(s.substring(0, s.indexOf("+")));
            imaginary = Integer.parseInt(s.substring(s.indexOf("+") + 1, s.indexOf("i")));
        }

        ComplexNumber multiply(ComplexNumber other) {
            int tempReal = real * other.real - imaginary * other.imaginary;
            imaginary = real * other.imaginary + imaginary * other.real;
            real = tempReal;

            return this;
        }

        @Override
        public String toString() {
            return real + "+" + imaginary + "i";
        }
    }
}
