package hackerrank.java.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-lambda-expressions
 */
public class JavaLambdaExpressions {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.is_odd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.is_prime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.is_palindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }

    interface PerformOperation {
        boolean check(int a);
    }

    private static class MyMath {
        public static boolean checker(PerformOperation p, int num) {
            return p.check(num);
        }

        public PerformOperation is_odd() {
            return a -> a % 2 != 0;
        }

        public PerformOperation is_prime() {
            return MyMath::isPrime;
        }

        public PerformOperation is_palindrome() {
            return MyMath::isPalindrome;
        }

        private static boolean isPalindrome(int n) {
            final String str = String.valueOf(n);
            int start = 0, end = str.length() - 1;

            while (start < end) {
                if (str.charAt(start) != str.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }

            return true;
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
