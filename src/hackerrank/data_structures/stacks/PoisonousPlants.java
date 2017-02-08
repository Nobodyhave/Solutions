package hackerrank.data_structures.stacks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 07/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/poisonous-plants
 */
public class PoisonousPlants {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        final int[] p = new int[N];
        final int[] days = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = in.nextInt();
        }

        int min = p[0];
        int max = 0;
        final Stack<Integer> s = new Stack<>();

        s.push(0);

        for (int i = 1; i < N; i++) {
            if (p[i] > p[i - 1]) {
                days[i] = 1;
            }

            min = (min < p[i]) ? min : p[i];

            while (!s.isEmpty() && p[s.peek()] >= p[i]) {
                if (p[i] > min) {
                    days[i] = (days[i] > days[s.peek()] + 1) ? days[i] : days[s.peek()] + 1;
                }

                s.pop();
            }

            max = (max > days[i]) ? max : days[i];
            s.push(i);
        }

        System.out.println(max);
    }
}
