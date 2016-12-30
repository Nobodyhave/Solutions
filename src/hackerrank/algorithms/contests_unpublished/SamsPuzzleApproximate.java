package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/world-codesprint-8/challenges/sams-puzzle
 */
public class SamsPuzzleApproximate {
    public static void main(String[] args) throws FileNotFoundException {
        final long tStart = System.currentTimeMillis();
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int n = in.nextInt();
        final int[][] puzzle = new int[n][n];
        for (int puzzle_i = 0; puzzle_i < n; puzzle_i++) {
            for (int puzzle_j = 0; puzzle_j < n; puzzle_j++) {
                puzzle[puzzle_i][puzzle_j] = in.nextInt();
            }
        }

        final Random rand = new Random();
        State initState = new State(new ArrayList<>(), puzzle, new Move(0, 0, 0), -1);
        initState.moves.clear();
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(initState);
        int limit = n * n * (n - 1);
        State bestState = initState;
        while (!pq.isEmpty()) {
            final State state = pq.poll();

            if (state.goodness > bestState.goodness) {
                bestState = state;
            }

            if (state.goodness == limit) {
                break;
            } else if (state.movesCount >= 500) {
                break;
            }

            boolean maxFound = true;
            for (int k = n; k >= 2; k--) {
                for (int i = n - k; i >= 0; i--) {
                    for (int j = n - k; j >= 0; j--) {
                        State newState = new State(state.moves, state.board, new Move(i, j, k), state.movesCount);
                        if (pq.isEmpty() || pq.peek().goodness <= newState.goodness) {
                            pq.add(newState);
                            maxFound = false;
                        }
                    }
                }
            }

            if (maxFound) {
                pq = new PriorityQueue<>();
                int randK = rand.nextInt(n - 1) + 2;
                int randI = rand.nextInt(n - randK + 1);
                int randJ = rand.nextInt(n - randK + 1);
                pq.add(new State(new ArrayList<>(), puzzle, new Move(randI, randJ, randK), 0));
            }

            long tEnd = System.currentTimeMillis();
            if (tEnd - tStart > 3900) {
                break;
            }
        }

        System.out.println(bestState.movesCount);
        for (Move move : bestState.moves) {
            System.out.format("%d %d %d\n", move.i + 1, move.j + 1, move.k);
        }

    }

    private static class State implements Comparable<State> {
        List<Move> moves;
        int[][] board;
        int movesCount;
        int goodness;

        public State(List<Move> moves, int[][] board, Move move, int count) {
            this.moves = new ArrayList<>(moves);
            this.moves.add(move);
            this.board = copyBoard(board);
            makeMove(this.board, move);
            goodness = calculateGoodness(this.board);
            this.movesCount = count + 1;
        }

        private int[][] copyBoard(int[][] board) {
            int[][] newBoard = new int[board.length][board[0].length];

            for (int i = 0; i < board.length; i++) {
                System.arraycopy(board[i], 0, newBoard[i], 0, board[0].length);
            }

            return newBoard;
        }

        private void makeMove(int[][] board, Move move) {
            int layers = (move.k - 1) / 2 + 1;
            // Cycle to iterate layers
            for (int i = 0; i < layers; i++) {
                // Cycle to iterate cells
                int sideLength = move.k - i * 2;
                for (int j = 0; j < sideLength - 1; j++) {
                    int firstR = i + move.i;
                    int firstC = i + j + move.j;
                    int secondR = i + j + move.i;
                    int secondC = sideLength - 1 + i + move.j;
                    int thirdR = sideLength - 1 + i + move.i;
                    int thirdC = sideLength - 1 + i - j + move.j;
                    int fourthR = sideLength - 1 + i - j + move.i;
                    int fourthC = i + move.j;
                    int temp = board[firstR][firstC];
                    board[firstR][firstC] = board[fourthR][fourthC];
                    board[fourthR][fourthC] = board[thirdR][thirdC];
                    board[thirdR][thirdC] = board[secondR][secondC];
                    board[secondR][secondC] = temp;
                }
            }
        }

        private int calculateGoodness(int[][] board) {
            int goodness = 0;
            for (int[] aBoard : board) {
                for (int j = 0; j < board[0].length - 1; j++) {
                    for (int k = j + 1; k < board[0].length; k++) {
                        if (aBoard[j] < aBoard[k]) {
                            goodness++;
                        }
                    }
                }
            }

            for (int i = 0; i < board[0].length; i++) {
                for (int j = 0; j < board.length - 1; j++) {
                    for (int k = j + 1; k < board.length; k++) {
                        if (board[j][i] < board[k][i]) {
                            goodness++;
                        }
                    }
                }
            }

            return goodness;
        }

        @Override
        public int compareTo(State o) {
            int result = Integer.compare(o.goodness, goodness);

            if (result == 0) {
                result = Integer.compare(movesCount, o.movesCount);
            }

            return result;
        }
    }

    private static class Move {
        int i;
        int j;
        int k;

        public Move(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
}
