package hackerrank.tutorial.the_30_days_of_code;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-scope
 */
public class Scope {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        final Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }

    private static class Difference {
        private int[] elements;
        public int maximumDifference;

        public Difference(int[] a) {
            elements = new int[a.length];
            System.arraycopy(a, 0, elements, 0, a.length);
        }

        public void computeDifference() {
            for (int i = 0; i < elements.length; i++) {
                elements[i] = Math.abs(elements[i]);
                java.util.Arrays.sort(elements);
                maximumDifference = elements[elements.length - 1] - elements[0];
            }
        }
    }

}
