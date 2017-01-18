package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 10/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w28/challenges/the-great-xor
 */
public class TheGreatXor {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            final long x = in.nextLong();
            long highBit = Long.highestOneBit(x);

            long count = (highBit - 1) - (x & (~highBit));


            System.out.println(count);
        }
    }
}
