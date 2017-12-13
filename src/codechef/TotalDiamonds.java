package codechef;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Aleksandr on 01/12/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/DEC17/problems/GIT01
 */
public class TotalDiamonds {
    private static final Map<Integer, Integer> CACHE = new HashMap<>();
    private static final long[] result = new long[10000001];

    private static void generateTest() throws IOException {
        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        final Random rand = new Random();
        final int T = 100000;
        fw.append(String.valueOf(T));
        fw.append("\n");
        for (int i = 0; i < T; i++) {
            final int N = 1000000;
            fw.append(String.valueOf(N));
            fw.append("\n");
        }

        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        //final Scanner in = new Scanner(System.in);
        generateTest();
        long t1 = System.currentTimeMillis();
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        calculateVeryClever(1000000);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            System.out.println(result[N + 1]);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time: " + (t2 - t1));
    }

    private static void calculateVeryClever(int N) {
        result[1] = 2;
        long sum = 2, curLineSum = 2;
        int start = 2, end = 3;
        for (int i = 2; i <= N; i++) {
            curLineSum += calculateDiamonds(end);
            curLineSum -= calculateDiamonds(start++);
            curLineSum += calculateDiamonds(++end);

            sum += 2 * curLineSum - calculateDiamonds(end);
            result[i + 1] = sum;
            end++;
        }
    }

    private static int calculateDiamonds(int num) {
        Integer val = CACHE.get(num);
        if (val != null) {
            return val;
        }

        int sum = 0;
        while (num != 0){
            int n = num % 10;
            if ((n & 1) == 0) {
                sum += n;
            } else {
                sum -= n;
            }
            num /= 10;
        }

        CACHE.put(num, Math.abs(sum));

        return Math.abs(sum);
    }
}
