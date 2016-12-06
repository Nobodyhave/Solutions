package hackerrank.mathematics.fundamentals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Aleksandr on 06/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/special-multiple
 */
public class SpecialMultiple {
    private static final Set<Long> MULTIPLES = new TreeSet<>();

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        generateMultiples(new StringBuilder("9"));

        final Map<Integer, Long> divisors = new HashMap<>();
        for (int i = 1; i <= 500; i++) {
            for (Long m : MULTIPLES) {
                if (m % i == 0) {
                    divisors.put(i, m);
                    break;
                }
            }
        }

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();

            System.out.println(divisors.get(N));
        }
    }

    private static void generateMultiples(StringBuilder sb) {
        try {
            MULTIPLES.add(Long.parseLong(sb.toString()));
        } catch (NumberFormatException e) {
            return;
        }

        generateMultiples(sb.append("0"));
        sb.deleteCharAt(sb.length() - 1);
        generateMultiples(sb.append("9"));
        sb.deleteCharAt(sb.length() - 1);
    }
}
