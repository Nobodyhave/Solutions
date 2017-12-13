package codechef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 01/12/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/DEC17/problems/GIT01
 */
public class ChefAndHisCake {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int M = in.nextInt();

            final char[][] cake = new char[N][M];
            final char[][] idealCakeRed = new char[N][M];
            final char[][] idealCakeGreen = new char[N][M];

            for (int i = 0; i < N; i++) {
                cake[i] = in.next().toCharArray();
                for (int j = 0; j < M; j++) {
                    if ((i & 1) == 0) {
                        if ((j & 1) == 0) {
                            idealCakeRed[i][j] = 'R';
                            idealCakeGreen[i][j] = 'G';
                        } else {
                            idealCakeRed[i][j] = 'G';
                            idealCakeGreen[i][j] = 'R';
                        }
                    } else {
                        if ((j & 1) == 0) {
                            idealCakeRed[i][j] = 'G';
                            idealCakeGreen[i][j] = 'R';
                        } else {
                            idealCakeRed[i][j] = 'R';
                            idealCakeGreen[i][j] = 'G';
                        }
                    }
                }
            }
            int redCost = 0, greenCost = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (cake[i][j] != idealCakeRed[i][j]) {
                        redCost += cake[i][j] == 'R' ? 5 : 3;
                    }
                    if (cake[i][j] != idealCakeGreen[i][j]) {
                        greenCost += cake[i][j] == 'R' ? 5 : 3;
                    }
                }
            }

            System.out.println(Math.min(redCost, greenCost));
        }
    }
}
