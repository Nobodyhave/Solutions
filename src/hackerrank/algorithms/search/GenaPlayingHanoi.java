package hackerrank.algorithms.search;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Aleksandr on 16/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/gena
 */
public class GenaPlayingHanoi {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        final boolean[] marked = new boolean[(int) Math.pow(2, 22)];

        final State initial = new State();
        final int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = in.nextInt();
        }
        for (int i = N - 1; i >= 0; i--) {
            if (data[i] - 1 == 0) {
                // Don't touch
            } else if (data[i] - 1 == 1) {
                initial.state |= 1 << (2 * i);
            } else if (data[i] - 1 == 2) {
                initial.state |= 1 << (2 * i + 1);
            } else {
                initial.state |= 1 << (2 * i);
                initial.state |= 1 << (2 * i + 1);
            }
        }

        marked[initial.state] = true;
        final PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(initial);

        while (!pq.isEmpty()) {
            State state = pq.poll();

            if (state.isSolved()) {
                System.out.println(state.moves);
                break;
            }

            int[] rods = new int[4];
            Arrays.fill(rods, -1);

            for (int i = N - 1; i >= 0; i--) {
                int mask = 0b11 << (2 * i);
                rods[(state.state & mask) >> (2 * i)] = i;
            }

            for (int i = 0; i < 4; i++) {
                if (rods[i] != -1) {
                    for (int j = 0; j < 4; j++) {
                        if (i == j) {
                            continue;
                        }
                        if (rods[j] == -1 || rods[i] < rods[j]) {
                            int stateNum = state.state;
                            if (j == 0) {
                                stateNum = setBit(stateNum, 2 * rods[i], 0);
                                stateNum = setBit(stateNum, 2 * rods[i] + 1, 0);
                            } else if (j == 1) {
                                stateNum = setBit(stateNum, 2 * rods[i], 1);
                                stateNum = setBit(stateNum, 2 * rods[i] + 1, 0);
                            } else if (j == 2) {
                                stateNum = setBit(stateNum, 2 * rods[i], 0);
                                stateNum = setBit(stateNum, 2 * rods[i] + 1, 1);
                            } else {
                                stateNum = setBit(stateNum, 2 * rods[i], 1);
                                stateNum = setBit(stateNum, 2 * rods[i] + 1, 1);
                            }
                            if (!marked[stateNum]) {
                                marked[stateNum] = true;
                                pq.add(new State(stateNum, state.moves + 1));
                            }
                        }
                    }
                }
            }
        }

    }

    private static int setBit(int num, int bit, int value) {
        if (value == 1) {
            return num | 1 << bit;
        } else {
            return num & (~(1 << bit));
        }
    }

    private static class State implements Comparable<State> {
        private int state;
        private int moves;

        State() {
        }

        State(int newState, int moves) {
            this();
            state = newState;
            this.moves = moves;
        }

        boolean isSolved() {
            return state == 0;
        }

        @Override
        public int compareTo(State o) {
            return moves - o.moves;
        }
    }
}
