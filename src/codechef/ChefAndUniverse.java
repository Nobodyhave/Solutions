package codechef;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Aleksandr on 04/12/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/DEC17/problems/CHEFUNI
 */
public class ChefAndUniverse {
    private static void generateTest() throws IOException {
        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        final Random rand = new Random();
        final int T = 1;
        fw.append(String.valueOf(T));
        fw.append("\n");
        for (int t = 0; t < T; t++) {
            final int X = rand.nextInt(50) + 1;
            final int Y = rand.nextInt(50) + 1;
            final int Z = rand.nextInt(50) + 1;
            final int A = rand.nextInt(100) + 1;
            final int B = rand.nextInt(100) + 1;
            final int C = rand.nextInt(100) + 1;
            fw.append(String.valueOf(X));
            fw.append(" ");
            fw.append(String.valueOf(Y));
            fw.append(" ");
            fw.append(String.valueOf(Z));
            fw.append(" ");
            fw.append(String.valueOf(A));
            fw.append(" ");
            fw.append(String.valueOf(B));
            fw.append(" ");
            fw.append(String.valueOf(C));
            fw.append("\n");
        }

        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        // TODO: How to speed up from Nlg(N) in binarySearches to lg(N) or constant? Binary and ternary searches don't work due to function multi-modality
        //generateTest();
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int Z = in.nextInt();
            final int A = in.nextInt();
            final int B = in.nextInt();
            final int C = in.nextInt();

            bruteDynamic(X, Y, Z, A, B, C);
            binarySearches(X, Y, Z, A, B, C);
        }
    }

    private static void binarySearches(int X, int Y, int Z, int A, int B, int C) {
        int maxSteps3D = findMin(X, Y, Z);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= maxSteps3D; i++) {
            result = Math.min(result, i * C + getMinTwoOneDist(X - i, Y - i, Z - i, A, B));
            System.out.println(i + "," + (i * C + getMinTwoOneDist(X - i, Y - i, Z - i, A, B)));
            //System.out.println(i + "," + (i * C + getMinTwoOneDist(X - i, Y - i, Z - i, A, B)));
            //System.out.println("----------------------");
        }

        System.out.println(result);
    }

    private static int getMinTwoOneDist(int x, int y, int z, int A, int B) {
        int start2 = 0;
        int end2;
        int dist2;
        int minNum = findMin(x, y, z);
        int midNum = findMid(x, y, z);
        int maxNum = findMax(x, y, z);
        end2 = calculateEnd2(x, y, z);
        dist2 = end2 * B + (minNum + midNum + maxNum - 2 * end2) * A;
        while (start2 <= end2) {
            final int mid = start2 + (end2 - start2) / 2;
            final int midDist = mid * B + (minNum + midNum + maxNum - 2 * mid) * A;
            if (midDist <= dist2) {
                dist2 = midDist;
                end2 = mid - 1;
            } else {
                start2 = mid + 1;
            }
        }

        return dist2;
    }

    private static int calculateEnd2(int x, int y, int z) {
        int end2;
        int minNum = findMin(x, y, z);
        int midNum = findMid(x, y, z);
        int maxNum = findMax(x, y, z);
        if (x != 0 && y != 0 && z != 0) {
            if (maxNum >= minNum + midNum) {
                end2 = minNum + midNum;
            } else {
                int extraPairs = (minNum + midNum + 1 - maxNum) / 2;
                end2 = extraPairs + (minNum + midNum - 2 * extraPairs);
            }

        } else if ((x != 0 && y != 0) || (x != 0 && z != 0) || (y != 0 && z != 0)) {
            end2 = midNum;
        } else if (x != 0 || y != 0 || z != 0) {
            end2 = 0;
        } else {
            end2 = 0;
        }

        return end2;
    }

    private static void bruteDynamic(int X, int Y, int Z, int A, int B, int C) {
        final int[][][] dp = new int[X + 1][Y + 1][Z + 1];
        for (int x = 0; x <= X; x++) {
            for (int y = 0; y <= Y; y++) {
                Arrays.fill(dp[x][y], Integer.MAX_VALUE);
            }
        }
        dp[0][0][0] = 0;

        for (int x = 0; x <= X; x++) {
            for (int y = 0; y <= Y; y++) {
                for (int z = 0; z <= Z; z++) {
                    if (x - 1 >= 0 && y - 1 >= 0 && z - 1 >= 0) {
                        dp[x][y][z] = Math.min(dp[x][y][z], dp[x - 1][y - 1][z - 1] + C);
                    }
                    if (x - 1 >= 0 && y - 1 >= 0) {
                        dp[x][y][z] = Math.min(dp[x][y][z], dp[x - 1][y - 1][z] + B);
                    }
                    if (x - 1 >= 0 && z - 1 >= 0) {
                        dp[x][y][z] = Math.min(dp[x][y][z], dp[x - 1][y][z - 1] + B);
                    }
                    if (z - 1 >= 0 && y - 1 >= 0) {
                        dp[x][y][z] = Math.min(dp[x][y][z], dp[x][y - 1][z - 1] + B);
                    }
                    if (x - 1 >= 0) {
                        dp[x][y][z] = Math.min(dp[x][y][z], dp[x - 1][y][z] + A);
                    }
                    if (y - 1 >= 0) {
                        dp[x][y][z] = Math.min(dp[x][y][z], dp[x][y - 1][z] + A);
                    }
                    if (z - 1 >= 0) {
                        dp[x][y][z] = Math.min(dp[x][y][z], dp[x][y][z - 1] + A);
                    }
                }
            }
        }

        /*for (int x = 0; x <= X; x++) {
            for (int y = 0; y <= Y; y++) {
                for (int z = 0; z <= Z; z++) {
                    System.out.format("%2d ", dp[x][y][z]);
                }
                System.out.println();
            }
            System.out.println();
        }*/

        System.out.println(dp[X][Y][Z]);
    }

    private static int findMin(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

    private static int findMid(int x, int y, int z) {
        if ((y <= x && x <= z) || (z <= x && x <= y)) {
            return x;
        } else if ((x <= y && y <= z) || (z <= y && y <= x)) {
            return y;
        } else {
            return z;
        }
    }

    private static int findMax(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }
}
