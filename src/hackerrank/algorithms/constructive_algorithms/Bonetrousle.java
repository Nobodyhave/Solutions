package hackerrank.algorithms.constructive_algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/bonetrousle
 */
public class Bonetrousle {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            final long n = scanner.nextLong();
            long k = scanner.nextLong();
            final long b = scanner.nextLong();

            // Sum of first b-1 boxes
            final long sum = (b - 1) * b / 2;
            long diff = n - sum;
            boolean solvable = true;

            long right = b - 1;
            final List<Long> nums = new ArrayList<>();
            while (diff != 0) {
                if (right < 0) {
                    solvable = false;
                    break;
                }

                if (diff > 0) { // We have chosen too small numbers
                    if (diff > right) { // We can pick unused numbers
                        if (diff <= k) { // We can directly pick 1 number and finish
                            nums.add(diff);
                            diff = 0;
                        } else { // We will need to pick max number and them modify some of the rest
                            nums.add(k); // Print largest
                            diff -= (k - right); // Decrease diff by gained difference
                            k--; // Decrease possible max number
                            right--; // Change maximum of the smallest numbers
                        }
                    } else { // We have to modify already picked numbers
                        nums.add(right + diff); // Print largest
                        diff = 0;
                        right--;
                    }
                } else { // Even summing small number exceeds k
                    solvable = false;
                    break;
                }
            }

            if (b != right + nums.size()) {
                solvable = false;
            }

            final StringBuilder sb = new StringBuilder();
            if (solvable) {
                for (long i = 1; i <= right; i++) {
                    sb.append(i).append(" ");
                }
                for (Long num : nums) {
                    sb.append(num).append(" ");
                }
            } else {
                sb.append(-1);
            }
            System.out.println(sb.toString().trim());
        }
    }
}
