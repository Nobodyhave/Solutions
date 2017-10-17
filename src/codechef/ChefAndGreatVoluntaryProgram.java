package codechef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 10/10/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/OCT17/problems/CHEFGP
 */
public class ChefAndGreatVoluntaryProgram {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            System.out.println(solve(in.next(), in.nextInt(), in.nextInt()));
        }
    }

    private static String solve(String input, int x, int y) {
        int aCount = 0, bCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                aCount++;
            } else {
                bCount++;
            }
        }

        int aSeq = (int) Math.ceil((double) aCount / x);
        int bSeq = (int) Math.ceil((double) bCount / y);

        final StringBuilder sb = new StringBuilder();
        if (aSeq >= bSeq) { // Apples will make more sequences for division
            if (bCount >= aSeq - 1) { // Apple sequences can be divided with bananas
                if (aSeq * y >= bCount) { // All bananas can be consumed as separators
                    fillFruits(sb, aCount, bCount, (int) Math.ceil((double) aCount / aSeq), bCount / aSeq, bCount % aSeq, true, x, y);
                } else { // Some of bananas should be divided by kiwis
                    fillFruits(sb, aCount, bCount, (int) Math.ceil((double) aCount / aSeq), bCount / aSeq, bCount % aSeq, true, x, y);
                }
            } else { // Not enough bananas to divide even by one banana
                fillFruits(sb, aCount, bCount, (int) Math.ceil((double) aCount / aSeq), 1, 0, true, x, y);
            }
        } else { // Mirror case
            if (aCount >= bSeq - 1) {
                if (bSeq * x >= aCount) {
                    fillFruits(sb, aCount, bCount, aCount / bSeq, (int) Math.ceil((double) bCount / bSeq), aCount % bSeq, false, x, y);
                } else {
                    fillFruits(sb, aCount, bCount, aCount / bSeq, (int) Math.ceil((double) bCount / bSeq), aCount % bSeq, false, x, y);
                }
            } else {
                fillFruits(sb, aCount, bCount, 1, (int) Math.ceil((double) bCount / bSeq), 0, false, x, y);
            }
        }

        return sb.toString();
    }

    private static void fillFruits(StringBuilder sb, int aCount, int bCount, int aSeqLength, int bSeqLength, int leftOver, boolean applesFirst, int x, int y) {
        while (aCount > 0 && bCount > 0) {
            if (applesFirst) {
                for (int a = 0; a < aSeqLength && aCount > 0; a++) {
                    sb.append('a');
                    aCount--;
                }
                for (int b = 0; b < bSeqLength && bCount > 0; b++) {
                    sb.append('b');
                    bCount--;
                }
                if (leftOver > 0) {
                    sb.append('b');
                    bCount--;
                    leftOver--;
                }
            } else {
                for (int b = 0; b < bSeqLength && bCount > 0; b++) {
                    sb.append('b');
                    bCount--;
                }
                for (int a = 0; a < aSeqLength && aCount > 0; a++) {
                    sb.append('a');
                    aCount--;
                }
                if (leftOver > 0) {
                    sb.append('a');
                    aCount--;
                    leftOver--;
                }
            }
        }

        while (aCount > 0) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == 'a') {
                sb.append('*');
            }
            for (int a = 0; a < x && aCount > 0; a++) {
                sb.append('a');
                aCount--;
            }
        }
        while (bCount > 0) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == 'b') {
                sb.append('*');
            }
            for (int b = 0; b < y && bCount > 0; b++) {
                sb.append('b');
                bCount--;
            }
        }
    }
}
