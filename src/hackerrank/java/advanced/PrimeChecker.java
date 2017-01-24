package hackerrank.java.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

/**
 * Created by Aleksandr on 23/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/prime-checker
 */
public class PrimeChecker {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static class Prime {

        public void checkPrime(int... nums) {
            StringBuilder sb = new StringBuilder();
            for (Integer n : nums) {
                if (isPrime(n)) {
                    sb.append(n).append(" ");
                }
            }
            System.out.println(sb.toString());
        }

        private static boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            } else if (n == 2) {
                return true;
            } else if (n % 2 == 0) {
                return false;
            }

            final int m = (int) Math.sqrt(n) + 1;

            for (int i = 3; i <= m; i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
