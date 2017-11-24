package codechef;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 13/11/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/NOV17/problems/CSUBQ/
 */
public class ChefAndSubarrayQueries {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        final int Q = in.nextInt();
        final int L = in.nextInt();
        final int R = in.nextInt();

        in.nextLine();
        final int[] nums = new int[N + 1];
        for (int q = 0; q < Q; q++) {
            final String str = in.nextLine();
            final String[] split = str.split(" ");

            if ("1".equals(split[0])) {
                final int x = Integer.parseInt(split[1]);
                final int y = Integer.parseInt(split[2]);
                update(nums, x, y);
            } else {
                final int l = Integer.parseInt(split[1]);
                final int r = Integer.parseInt(split[2]);

                System.out.println(getCount(nums, L, R, l, r));
            }
        }
    }

    private static void update(int[] nums, int x, int y) {
        nums[x] = y;
    }

    private static int getCount(int[] nums, int L, int R, int l, int r) {
        int count = 0;
        for (int start = l; start <= r; start++) {
            int max = nums[start];
            for (int end = start; end <= r; end++) {
                max = Math.max(max, nums[end]);
                if (max >= L && max <= R) {
                    count++;
                } else if (max > R) {
                    break;
                }
            }
        }

        return count;
    }
}
