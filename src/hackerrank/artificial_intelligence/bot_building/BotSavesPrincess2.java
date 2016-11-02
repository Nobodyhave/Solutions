package hackerrank.artificial_intelligence.bot_building;

/**
 * Created by Aleksandr on 31/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/saveprincess2
 */

import java.util.Scanner;

public class BotSavesPrincess2 {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        int rowM = in.nextInt();
        int colM = in.nextInt();

        final char[][] grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            final String str = in.next();
            for (int j = 0; j < N; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        /*while(true) {
            int[] move = nextMove(N, rowM, colM, grid);
            if(move[0] == 0 && move[1] == 0) {
                break;
            }

            rowM += move[0];
            colM += move[1];
        }*/
        nextMove(N, rowM, colM, grid);
    }

    public static int[] nextMove(int N, int rowM, int colM, char[][] grid) {
        int rowP = 0, colP = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'p') {
                    rowP = i;
                    colP = j;
                }
            }
        }

        if (rowP < rowM) {
            System.out.println("UP");
            return new int[]{-1, 0};
        } else if (rowP > rowM) {
            System.out.println("DOWN");
            return new int[]{1, 0};
        } else {
            if (colP < colM) {
                System.out.println("LEFT");
                return new int[]{0, -1};
            } else if (colP > colM) {
                System.out.println("RIGHT");
                return new int[]{0, 1};
            }
        }

        return new int[]{0, 0};
    }
}
