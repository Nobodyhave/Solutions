package codechef;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 06/12/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/DEC17/problems/REDBLUE
 */
public class RedAndBluePoints {
    public static void main(String[] args) throws IOException {
        // TODO: To speed up may be taking lines in consideration using clockwise direction will work
        //generateTest();
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            int M = in.nextInt();

            final int[] redX = new int[N];
            final int[] redY = new int[N];
            for (int i = 0; i < N; i++) {
                redX[i] = in.nextInt();
                redY[i] = in.nextInt();
            }

            final int[] blueX = new int[M];
            final int[] blueY = new int[M];
            for (int i = 0; i < M; i++) {
                blueX[i] = in.nextInt();
                blueY[i] = in.nextInt();
            }

            if(N == 1 && M == 1) {
                System.out.println(0);
            } else {
                brute(redX, redY, blueX, blueY);
            }
        }
    }

    private static void brute(int[] redX, int[] redY, int[] blueX, int[] blueY) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < redX.length; i++) {
            outer:
            for (int j = i + 1; j < redX.length; j++) {
                int redLeft = 0, redRight = 0, blueLeft = 0, blueRight = 0;
                for (int k = 0; k < redX.length; k++) {
                    if (k != i && k != j) {
                        final int orientation = orientation(redX[i], redY[i], redX[j], redY[j], redX[k], redY[k]);
                        if (orientation < 0) {
                            redLeft++;
                        } else if (orientation > 0) {
                            redRight++;
                        } else {
                            continue outer;
                        }
                    }
                }
                for (int k = 0; k < blueX.length; k++) {
                    final int orientation = orientation(redX[i], redY[i], redX[j], redY[j], blueX[k], blueY[k]);
                    if (orientation < 0) {
                        blueLeft++;
                    } else if (orientation > 0) {
                        blueRight++;
                    } else {
                        continue outer;
                    }
                }
                min = Math.min(min, blueLeft + redRight);
                min = Math.min(min, blueRight + redLeft);
            }
        }

        for (int i = 0; i < blueX.length; i++) {
            outer:
            for (int j = i + 1; j < blueX.length; j++) {
                int redLeft = 0, redRight = 0, blueLeft = 0, blueRight = 0;
                for (int k = 0; k < blueX.length; k++) {
                    if (k != i && k != j) {
                        final int orientation = orientation(blueX[i], blueY[i], blueX[j], blueY[j], blueX[k], blueY[k]);
                        if (orientation < 0) {
                            blueLeft++;
                        } else if (orientation > 0) {
                            blueRight++;
                        } else {
                            continue outer;
                        }
                    }
                }
                for (int k = 0; k < redX.length; k++) {
                    final int orientation = orientation(blueX[i], blueY[i], blueX[j], blueY[j], redX[k], redY[k]);
                    if (orientation < 0) {
                        redLeft++;
                    } else if (orientation > 0) {
                        redRight++;
                    } else {
                        continue outer;
                    }
                }
                min = Math.min(min, blueLeft + redRight);
                min = Math.min(min, blueRight + redLeft);
            }
        }

        System.out.println(min);
    }

    private static int orientation(long x1, long y1, long x2, long y2, long x3, long y3) {
        long val = (y2 - y1) * (x3 - x2) - (x2 - x1) * (y3 - y2);
        if (val == 0) return 0;
        return (val > 0) ? 1 : -1;
    }
}
