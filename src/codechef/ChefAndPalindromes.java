package codechef;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Aleksandr on 11/01/2018.
 * Project Solutions
 * <p>
 * https://www.codechef.com/JAN18/problems/CHEFPALS
 */
public class ChefAndPalindromes {
    private static void generateTest() throws IOException {
        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        final Random rand = new Random();
        final int T = 1;
        //fw.append(String.valueOf(T));
        //fw.append("\n");
        for (int t = 0; t < T; t++) {
            final int N = 1000;//(int) Math.pow(2, 17) + 1;//rand.nextInt(100000) + 1;
            fw.append(String.valueOf(N));
            fw.append("\n");

            final int[] I = new int[N];
            for (int i = 0; i < N; i++) {
                I[i] = 1000;//rand.nextInt(1000) + 1;
                fw.append(String.valueOf(I[i]));
                fw.append(" ");
            }
            fw.append("\n");

            for (int i = 0; i < N; i++) {
                int b = rand.nextInt(I[i]);
                fw.append(String.valueOf(b));
                fw.append(" ");
            }
            fw.append("\n");
        }

        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws Exception {
        //generateTest();
        //final Scanner in = new Scanner(System.in);
        long t1 = System.currentTimeMillis();
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        final int[] nums = new int[N];
        final int[] I = new int[N];
        final int[] b = new int[N];
        final String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
            I[i] = in.nextInt();
        }
        for (int i = 0; i < N; i++) {
            b[i] = in.nextInt();
        }
        for (int i = 0; i < N; i++) {
            final StringBuilder sb = new StringBuilder();
            /*for (int j = 0; j < b[i]; j++) {
                sb.append('b');
            }
            for (int j = 0; j < I[i] - b[i]; j++) {
                sb.append('w');
            }*/
            for (int j = 0; j < I[i]; j++) {
                sb.append('w');
            }
            int bCount = b[i];
            if(b[i] < I[i]/112) {
                for (int j = 0; bCount > 0 && j < I[i]; j += 112, bCount--) {
                    sb.setCharAt(j, 'b');
                }
                for (int j = 1; bCount > 0 && j < I[i]; j ++) {
                    if(sb.charAt(j) != 'b') {
                        sb.setCharAt(j, 'b');
                        bCount--;
                    }
                }
            } else if(b[i] < I[i]/12) {
                for (int j = 0; bCount > 0 && j < I[i]; j += 12, bCount--) {
                    sb.setCharAt(j, 'b');
                }
                for (int j = 1; bCount > 0 && j < I[i]; j ++) {
                    if(sb.charAt(j) != 'b') {
                        sb.setCharAt(j, 'b');
                        bCount--;
                    }
                }
            } else {
                for (int j = 0; bCount > 0 && j < I[i]; j += 2, bCount--) {
                    sb.setCharAt(j, 'b');
                }
                for (int j = 1; bCount > 0 && j < I[i]; j += 2, bCount--) {
                    sb.setCharAt(j, 'b');
                }
            }

            final StringBuilder string = new StringBuilder();
            int count = 0;
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == 'w') {
                    count++;
                } else {
                    if (count != 0) {
                        string.append(count);
                    }
                    count = 0;
                }
            }
            if (count != 0) {
                string.append(count);
            }
            strings[i] = String.valueOf(string.toString());

            System.out.println(sb.toString());
        }

        int min = Integer.MAX_VALUE;
        StringBuilder minString = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            shuffleArray(nums);
            final StringBuilder sb = new StringBuilder();
            int cur = calculatePalindromness(sb, nums, strings);
            System.out.println(cur);
            if (cur < min) {
                min = cur;
                minString = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    minString.append(nums[j]);
                    minString.append(" ");
                }
            }
        }
        System.out.println(minString);

        long t2 = System.currentTimeMillis();
        System.out.println("Min: " + min + " Time: " + (t2 - t1));
    }

    private static int calculatePalindromness(StringBuilder sb, int[] nums, String[] strings) {
        for (int num : nums) {
            sb.append(strings[num - 1]);
        }
        int start = 0, end = sb.length() - 1, count = 0;
        while (start < end) {
            if (sb.charAt(start++) != sb.charAt(end--)) {
                count++;
            }
        }

        return count;
    }

    private static void shuffleArray(int[] a) {
        final Random rnd = ThreadLocalRandom.current();
        for (int i = a.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            swap(a, i, index);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
