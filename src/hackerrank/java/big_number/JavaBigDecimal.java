package hackerrank.java.big_number;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 16/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-bigdecimal
 */
public class JavaBigDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        Arrays.sort(s, 0, n, (o1, o2) -> new BigDecimal(o2).compareTo(new BigDecimal(o1)));

        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
