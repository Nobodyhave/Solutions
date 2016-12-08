package hackerrank.mathematics.fundamentals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 07/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/russian-peasant-exponentiation
 */
public class RussianPeasantExponentiation {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final long a = in.nextLong();
            final long b = in.nextLong();
            final long k = in.nextLong();
            final int m = in.nextInt();

            final Complex result = exponentiate(new Complex(a, b), k, m);

            System.out.println(result.real + " " + result.imaginary);
        }
    }

    private static Complex exponentiate(Complex x, long exp, int mod) {
        if (mod == 1) {
            return new Complex(0, 0);
        }

        Complex result = new Complex(1, 0);
        Complex base = x.mod(mod);

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result.multiply(base)).mod(mod);
            }
            exp = exp >> 1;
            base = base.multiply(base).mod(mod);
        }

        return result;
    }

    private static class Complex {
        private final long real;
        private final long imaginary;

        public Complex(long real, long imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public Complex multiply(Complex b) {
            Complex a = this;
            long real = (a.real * b.real) - (a.imaginary * b.imaginary);
            long imaginary = (a.real * b.imaginary) + (a.imaginary * b.real);
            return new Complex(real, imaginary);
        }

        public Complex mod(int mod) {
            return new Complex(Math.floorMod(real, mod), Math.floorMod(imaginary, mod));
        }
    }

}
