package hackerrank.algorithms.implementation;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 18/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/acm-icpc-team
 */
public class AcmIcpcTeam {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int M = in.nextInt();

        final BigInteger[] people = new BigInteger[N];

        for (int i = 0; i < N; i++) {
            people[i] = new BigInteger(in.next(), 2);
        }

        int max = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int team = people[i].or(people[j]).bitCount();
                if (team > max) {
                    max = team;
                    count = 1;
                } else if (team == max) {
                    count++;
                }
            }
        }

        System.out.println(max);
        System.out.println(count);
    }
}
