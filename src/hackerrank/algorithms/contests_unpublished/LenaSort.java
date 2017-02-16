package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 16/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack46/challenges/lena-sort
 */
public class LenaSort {
    private static final int N = 100001;
    private static final long[] bottom = new long[N];
    private static final long[] top = new long[N];

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int Q = in.nextInt();


        bottom[0] = 0;
        top[0] = 0;
        bottom[1] = 0;
        top[1] = 0;
        bottom[2] = 1;
        top[2] = 1;
        bottom[3] = 2;
        top[3] = 3;

        int inc = 1;
        for (int i = 4; i < N; i++) {
            if (Integer.bitCount(i) == 1) {
                inc++;
            }
            bottom[i] = bottom[i - 1] + inc;
            top[i] = top[i - 1] + (i - 1);
        }

        for (int q = 0; q < Q; q++) {
            final int len = in.nextInt();
            final int compares = in.nextInt();

            if (compares < bottom[len] || compares > top[len]) {
                System.out.println(-1);
                continue;
            }

            final StringBuilder sb = new StringBuilder();
            construct(sb, compares, 1, len);
            System.out.println(sb.toString());
        }
    }

    private static void construct(StringBuilder sb, long compares, int left, int right) {
        if (left > right) {
            return;
        } else if (left == right) {
            sb.append(left).append(" ");
            return;
        }

        int len = right - left + 1;
        long comparesLeft = compares - (len - 1);
        int leftSize = (len - 1) / 2;
        int rightSize;

        int start = 0, end = leftSize;
        int mid = -1;
        do {
            if (end - start != 1) {
                mid = start + (end - start) / 2;
            } else {
                if (mid == start) {
                    mid = end;
                } else {
                    mid = start;
                }
            }
            leftSize = mid;
            rightSize = len - 1 - leftSize;

            if (bottom[leftSize] + bottom[rightSize] > comparesLeft) {
                start = mid;
            } else if (top[leftSize] + top[rightSize] < comparesLeft) {
                end = mid;
            } else {
                break;
            }
        } while (true);

        sb.append(left + leftSize).append(" ");
        long leftSideCompares = top[leftSize];
        long rightSideCompares;

        long startC = 0, endC = leftSideCompares;
        long midC = -1;
        do {
            if (endC - startC != 1) {
                midC = startC + (endC - startC) / 2;
            } else {
                if (midC == startC) {
                    midC = endC;
                } else {
                    midC = startC;
                }
            }
            leftSideCompares = midC;
            rightSideCompares = comparesLeft - leftSideCompares;

            if (rightSideCompares < bottom[rightSize] || leftSideCompares > top[leftSize]) {
                endC = midC;
            } else if (rightSideCompares > top[rightSize] || leftSideCompares < bottom[leftSize]) {
                startC = midC;
            } else {
                break;
            }
        } while (true);

        construct(sb, leftSideCompares, left, left + leftSize - 1);
        construct(sb, rightSideCompares, left + leftSize + 1, right);
    }
}
