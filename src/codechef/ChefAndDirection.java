package codechef;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Aleksandr on 07/12/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/DEC17/problems/WESTAND
 */
public class ChefAndDirection {
    public static void main(String[] args) throws IOException {
        //generateTest();
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int K = in.nextInt();

            final Cook[] cooks = new Cook[K];
            boolean isSubtask2 = true;
            for (int k = 0; k < K; k++) {
                cooks[k] = new Cook(in.nextInt(), in.nextInt());
                if (k >= 1 && cooks[k].speed != cooks[k - 1].speed) {
                    isSubtask2 = false;
                }
            }

            final int N = in.nextInt();

            final Order[] orders = new Order[N];
            for (int n = 0; n < N; n++) {
                orders[n] = new Order(in.nextInt(), in.nextInt());
            }

            if (N == 1) {
                solveSubtaskOne(cooks, orders);
            } else if (isSubtask2) {
                solveSubtaskTwo(cooks, orders);
            } else {
                System.out.println("No solution yet");
            }
        }
    }

    private static void solveSubtaskOne(Cook[] cooks, Order[] orders) {
        Arrays.sort(cooks, Comparator.comparingInt(cook -> cook.salary));
        for (Cook cook : cooks) {
            if (cook.speed * orders[0].time >= orders[0].dishes) {
                System.out.println(cook.salary);
                return;
            }
        }

        System.out.println(-1);
    }

    private static void solveSubtaskTwo(Cook[] cooks, Order[] orders) {
        Arrays.sort(cooks, Comparator.comparingInt(cook -> cook.salary));
        final double speed = cooks[0].speed;
        for (Order order : orders) {
            order.timeToEnd = order.time - order.dishes / speed;
        }
        Arrays.sort(orders, Comparator.comparingDouble(order -> order.timeToEnd));

        outer:
        for (int i = 1; i <= Math.min(cooks.length, orders.length); i++) { // Iterate over number of cooks
            final PriorityQueue<Order>[] cooking = new PriorityQueue[i];
            for (int j = 0; j < cooking.length; j++) {
                cooking[j] = new PriorityQueue<>(Comparator.comparingDouble(order -> order.endTime));
            }
            int currentOrder = 0;
            double currentTime = 0;
            for (PriorityQueue<Order> queue : cooking) {
                orders[currentOrder].endTime = currentTime + orders[currentOrder].dishes / speed;
                queue.add(orders[currentOrder]);
                currentOrder++;
            }

            while (true) {
                double minEndTime = Double.POSITIVE_INFINITY;
                int minIndex = -1;
                for (int j = 0; j < cooking.length; j++) {
                    if (!cooking[j].isEmpty()) {
                        if (Double.compare(cooking[j].peek().endTime, minEndTime) < 0) {
                            minEndTime = cooking[j].peek().endTime;
                            minIndex = j;
                        }
                    }
                }
                if (minIndex == -1) {
                    break;
                }
                final Order order = cooking[minIndex].poll();
                if (Double.compare(order.endTime, order.time) > 0) {
                    continue outer;
                } else {
                    currentTime = order.endTime;
                    if (currentOrder < orders.length) {
                        orders[currentOrder].endTime = currentTime + orders[currentOrder].dishes / speed;
                        cooking[minIndex].add(orders[currentOrder]);
                        currentOrder++;
                    }
                }
            }

            int salary = 0;
            for (int j = 0; j < i; j++) {
                salary += cooks[j].salary;
            }
            System.out.println(salary);
            return;
        }
        System.out.println(-1);
    }

    private static class Cook {
        private int speed;
        private int salary;

        Cook(int speed, int salary) {
            this.speed = speed;
            this.salary = salary;
        }
    }

    private static class Order {
        private int dishes;
        private int time;
        private double endTime;
        private double timeToEnd;

        Order(int dishes, int time) {
            this.dishes = dishes;
            this.time = time;
        }
    }
}
