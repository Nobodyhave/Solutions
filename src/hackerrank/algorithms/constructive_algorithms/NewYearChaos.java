package hackerrank.algorithms.constructive_algorithms;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/new-year-chaos
 */
public class NewYearChaos {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();

            final int[] nums = new int[N];
            int count = 0;
            boolean isChaotic = false;
            final TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < N; i++) {
                nums[i] = in.nextInt();
                set.add(nums[i]);
                final int steps = Math.abs(i + 1 - nums[i]);
                if (steps > 2 && nums[i] > i) {
                    isChaotic = true;
                }
            }

            if (!isChaotic) {
                for (int i = 0; i < N; i++) {
                    final int num = nums[i];
                    set.remove(num);
                    count += set.headSet(num).size();
                }
            }

            if (isChaotic) {
                System.out.println("Too chaotic");
            } else {
                System.out.println(count);
            }
        }
    }
}
