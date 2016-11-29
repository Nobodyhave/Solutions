package hackerrank.algorithms.bit_manipulation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 29/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/counter-game
 */
public class CounterGame {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {

            BigInteger N = new BigInteger(in.next());

            int count = 0;
            while (!N.equals(BigInteger.ONE)) {
                int setBitsCount = 0;
                int firstBitIndex = -1;
                for (int i = 63; i >= 0; i--) {
                    final boolean isSet = N.testBit(i);

                    if (isSet) {
                        setBitsCount++;
                        if (firstBitIndex == -1) {
                            firstBitIndex = i;
                        }
                    }
                }

                if (setBitsCount == 1) {
                    N = N.shiftRight(firstBitIndex);
                    count += firstBitIndex;
                } else {
                    N = N.clearBit(firstBitIndex);
                    count++;
                }
            }

            if (count % 2 == 0) {
                System.out.println("Richard");
            } else {
                System.out.println("Louise");
            }
        }
    }
}
