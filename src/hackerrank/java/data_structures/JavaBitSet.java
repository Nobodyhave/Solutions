package hackerrank.java.data_structures;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by Aleksandr on 20/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-bitset
 */
public class JavaBitSet {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int M = in.nextInt();

        final BitSet[] bitSets = new BitSet[2];
        bitSets[0] = new BitSet(M);
        bitSets[1] = new BitSet(M);

        for (int i = 0; i < N; i++) {
            final String op = in.next();
            final int left = in.nextInt() - 1;
            final int right = in.nextInt() - 1;

            switch (op) {
                case "AND":
                    bitSets[left].and(bitSets[right]);
                    break;
                case "OR":
                    bitSets[left].or(bitSets[right]);
                    break;
                case "XOR":
                    bitSets[left].xor(bitSets[right]);
                    break;
                case "FLIP":
                    bitSets[left].flip(right + 1);
                    break;
                case "SET":
                    bitSets[left].set(right + 1);
                    break;
            }

            System.out.println(bitSets[0].cardinality() + " " + bitSets[1].cardinality());
        }
    }
}
