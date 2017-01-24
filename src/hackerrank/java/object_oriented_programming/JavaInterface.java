package hackerrank.java.object_oriented_programming;

import java.util.Scanner;

/**
 * Created by Aleksandr on 23/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-interface
 */
public class JavaInterface {
    public static void main(String[] args) {
        final MyCalculator myCalculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(myCalculator);
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        System.out.print(myCalculator.divisorSum(n) + "\n");
        sc.close();
    }

    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o) {
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++) {
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }

    private interface AdvancedArithmetic {
        int divisorSum(int n);
    }

    private static class MyCalculator implements AdvancedArithmetic {
        public int divisorSum(int n) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    sum += i;
                }
            }

            return sum;
        }
    }
}
