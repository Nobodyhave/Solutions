package hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 18/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/jim-and-the-orders
 */

public class JimAndTheOrders {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {
            orders[i] = new Order(i, in.nextInt() + in.nextInt());
        }

        Arrays.sort(orders);

        for (int i = 0; i < n; i++) {
            System.out.print((orders[i].id + 1) + " ");
        }
    }

    private static class Order implements Comparable<Order> {
        private int id;
        private int finishTime;

        public Order(int id, int finishTime) {
            this.id = id;
            this.finishTime = finishTime;
        }

        @Override
        public int compareTo(Order o) {
            int result = Integer.compare(finishTime, o.finishTime);

            if (result == 0) {
                result = Integer.compare(id, o.id);
            }

            return result;
        }
    }

}
