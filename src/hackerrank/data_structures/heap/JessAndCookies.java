package hackerrank.data_structures.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Aleksandr on 08/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/jesse-and-cookies
 */
public class JessAndCookies {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final int K = scanner.nextInt();

        final PriorityQueue<Integer> cookies = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            cookies.add(scanner.nextInt());
        }

        int count = 0;
        while (!cookies.isEmpty()) {
            final int c1 = cookies.poll();

            if (c1 >= K) {
                System.out.println(count);
                return;
            }
            if (cookies.isEmpty()) {
                System.out.println(-1);
                return;
            }
            final int c2 = cookies.poll();
            cookies.add(c1 + 2 * c2);
            count++;
        }

        System.out.println(-1);
    }
}
