package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/university-codesprint/challenges/hackerland-radio-transmitters
 */
public class HackerlandRadioTransmitters {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Training\\src\\problemsolving\\test_data.txt"));

        final int N = in.nextInt();
        final int k = in.nextInt();
        final int[] towers = new int[100000];
        for (int i = 0; i < N; i++) {
            towers[in.nextInt() - 1] = 1;
        }

        int start = 0;
        int newStart;
        int count = 0;
        while (start < towers.length) {
            while (start < towers.length && towers[start] != 1) {
                start++;
            }

            newStart = start + k;
            if (newStart >= towers.length) {
                newStart = towers.length - 1;
            }
            while (newStart >= start && towers[newStart] != 1) {
                newStart--;
            }
            if (newStart < start) {
                break;
            }
            start = newStart + k + 1;
            count++;
        }

        System.out.println(count);
    }
}
