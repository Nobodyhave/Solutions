package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 01/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w26/challenges/street-parade-1
 */
public class MusicOnTheStreet {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        final int[] a = new int[N + 2];
        for (int i = 1; i < N + 1; i++) {
            a[i] = in.nextInt();
        }
        final int m = in.nextInt();
        final int hMin = in.nextInt();
        final int hMax = in.nextInt();

        a[0] = a[1] - hMax;
        a[N + 1] = a[N] + hMax;

        int startSegment = 0;
        int start = a[startSegment];
        outer:
        while (true) {
            int dist = m;
            int segmentStart = start;
            int segmentEnd = a[startSegment + 1];
            while (dist > 0) {
                int segmentLength = segmentEnd - segmentStart;

                if (dist <= segmentLength) { // If dist is in the bounds of current segment
                    if (dist < hMin) { // If dist is small, move forward for lacking amount of miles
                        start += hMin - dist;
                        break;
                    } else if (dist >= hMin && dist <= hMax) { // If distance is valid then solution is found
                        break outer;
                    } else { // If distance is too big move to next segment
                        start = a[startSegment + 1] - hMax;
                        break;
                    }
                } else { // If distance is bigger then current segment
                    if (segmentLength < hMin) { // Segment is too small and path is invalid, move to next segment
                        start = a[startSegment + 1];
                        break;
                    } else if (segmentLength >= hMin && segmentLength <= hMax) { // Segment is valid, decrease path by its length
                        dist -= segmentLength;
                        startSegment++;
                        segmentStart = a[startSegment];
                        segmentEnd = a[startSegment + 1];
                    } else { // Segment is too big, path is invalid, move start to (segment end - hMax)
                        start = a[startSegment + 1] - hMax;
                        break;
                    }
                }
            }

            if (start >= a[startSegment + 1]) {
                startSegment++;
            }
        }

        System.out.println(start);
    }
}
