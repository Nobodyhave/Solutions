package hackerrank.algorithms;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Aleksandr on 21/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w29/challenges/big-sorting
 */
public class BigSorting {

    public static void main(String[] args) throws IOException {
        generateTest();
        long t1 = System.currentTimeMillis();
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int n = in.nextInt();
        String[] unsorted = new String[n];
        for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
            unsorted[unsorted_i] = in.next();
        }

        Arrays.sort(unsorted, (o1, o2) -> {
            int result = o1.length() - o2.length();

            if (result == 0) {
                result = o1.compareTo(o2);
            }

            return result;
        });

        for (String s : unsorted) {
            System.out.println(s);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time: " + (t2 - t1));
    }

    private static void generateTest() throws IOException {
        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        final StringBuilder sb = new StringBuilder();
        final Random rand = new Random();

        final int N = 200000;
        sb.append(N).append('\n');
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                sb.append(rand.nextInt(10));
                //sb.append(9);
            }
            sb.append('\n');
        }

        fw.write(sb.toString());
        fw.flush();
        fw.close();
    }
}
