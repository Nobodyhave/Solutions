package hackerrank.algorithms.implementation;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/queens-attack-2
 */
public class QueensAttackII {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));
        final int n = in.nextInt();
        final int k = in.nextInt();
        final int rQueen = in.nextInt();
        final int cQueen = in.nextInt();

        if (n < 2) {
            System.out.println(0);
            return;
        }

        int rowUL = Math.min(n + 1, rQueen + cQueen);

        int rowU = n + 1;

        int rowUR = Math.min(n + 1, rQueen + Math.abs(n + 1 - cQueen));

        int colR = n + 1;

        int rowDL = Math.max(0, rQueen - cQueen);

        int rowD = 0;

        int rowDR = Math.max(0, rQueen - Math.abs(n + 1 - cQueen));

        int colL = 0;

        for (int a0 = 0; a0 < k; a0++) {
            int rObstacle = in.nextInt();
            int cObstacle = in.nextInt();

            if (rObstacle == rQueen) {
                if (cObstacle < cQueen) {
                    colL = Math.max(colL, cObstacle);
                } else {
                    colR = Math.min(colR, cObstacle);
                }
            } else if (cObstacle == cQueen) {
                if (rObstacle < rQueen) {
                    rowD = Math.max(rowD, rObstacle);
                } else {
                    rowU = Math.min(rowU, rObstacle);
                }
            } else if (Math.abs(rQueen - rObstacle) == Math.abs(cQueen - cObstacle)) {
                if (rObstacle < rQueen) {
                    if (cObstacle < cQueen) {
                        rowDL = Math.max(rowDL, rObstacle);
                    } else {
                        rowDR = Math.max(rowDR, rObstacle);
                    }
                } else {
                    if (cObstacle < cQueen) {
                        rowUL = Math.min(rowUL, rObstacle);
                    } else {
                        rowUR = Math.min(rowUR, rObstacle);
                    }
                }
            }
        }

        int moves = Math.abs(rQueen - rowU) - 1;
        moves += Math.abs(rQueen - rowD) - 1;
        moves += Math.abs(rQueen - rowUL) - 1;
        moves += Math.abs(rQueen - rowUR) - 1;
        moves += Math.abs(rQueen - rowDR) - 1;
        moves += Math.abs(rQueen - rowDL) - 1;
        moves += Math.abs(cQueen - colL) - 1;
        moves += Math.abs(cQueen - colR) - 1;

        System.out.println(moves);
    }
}
