package hackerrank.algorithms.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Aleksandr on 29/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/board-cutting
 */
public class BoardCutting {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final int M = in.nextInt();
            final int N = in.nextInt();

            final PriorityQueue<Integer> weightsH = new PriorityQueue<>(new ReverseComparator());
            for (int m = 0; m < M - 1; m++) {
                weightsH.add(in.nextInt());
            }

            final PriorityQueue<Integer> weightsV = new PriorityQueue<>(new ReverseComparator());
            for (int n = 0; n < N - 1; n++) {
                weightsV.add(in.nextInt());
            }

            BigInteger countH = BigInteger.ONE;
            BigInteger countV = BigInteger.ONE;
            BigInteger countTotal = BigInteger.ZERO;
            while (!weightsH.isEmpty() || !weightsV.isEmpty()) {
                if (weightsH.isEmpty()) {
                    countTotal = countTotal.add(countH.multiply(BigInteger.valueOf(weightsV.poll())));
                    countV = countV.add(BigInteger.ONE);
                } else if (weightsV.isEmpty()) {
                    countTotal = countTotal.add(countV.multiply(BigInteger.valueOf(weightsH.poll())));
                    countH = countH.add(BigInteger.ONE);
                } else if (weightsH.peek() < weightsV.peek()) {
                    countTotal = countTotal.add(countH.multiply(BigInteger.valueOf(weightsV.poll())));
                    countV = countV.add(BigInteger.ONE);
                } else {
                    countTotal = countTotal.add(countV.multiply(BigInteger.valueOf(weightsH.poll())));
                    countH = countH.add(BigInteger.ONE);
                }
            }

            System.out.println(countTotal.mod(BigInteger.valueOf(1000000007)));
        }
    }

    private static class ReverseComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
}
