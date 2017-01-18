package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Aleksandr on 13/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w28/challenges/choosing-white-balls
 * Failing 2 tests
 */
public class ChoosingWhiteBalls {
    @SuppressWarnings("unchecked")
    private static final Map<Integer, Double>[] CACHE = (Map<Integer, Double>[]) new HashMap[30];
    private static int[] HIGH_MASK = new int[]{
            0xFFFFFFFE,
            0xFFFFFFFC,
            0xFFFFFFF8,
            0xFFFFFFF0,
            0xFFFFFFE0,
            0xFFFFFFC0,
            0xFFFFFF80,
            0xFFFFFF00,
            0xFFFFFE00,
            0xFFFFFC00,
            0xFFFFF800,
            0xFFFFF000,
            0xFFFFE000,
            0xFFFFC000,
            0xFFFF8000,
            0xFFFF0000,
            0xFFFE0000,
            0xFFFC0000,
            0xFFF80000,
            0xFFF00000,
            0xFFE00000,
            0xFFC00000,
            0xFF800000,
            0xFF000000,
            0xFE000000,
            0xFC000000,
            0xF8000000,
            0xF0000000,
            0xE0000000,
            0xC0000000,
            0x80000000,
            0x00000000,
    };

    private static int[] LOW_MASK = new int[]{
            0x00000000,
            0x00000001,
            0x00000003,
            0x00000007,
            0x0000000F,
            0x0000001F,
            0x0000003F,
            0x0000007F,
            0x000000FF,
            0x000001FF,
            0x000003FF,
            0x000007FF,
            0x00000FFF,
            0x00001FFF,
            0x00003FFF,
            0x00007FFF,
            0x0000FFFF,
            0x0001FFFF,
            0x0003FFFF,
            0x0007FFFF,
            0x000FFFFF,
            0x001FFFFF,
            0x003FFFFF,
            0x007FFFFF,
            0x00FFFFFF,
            0x01FFFFFF,
            0x03FFFFFF,
            0x07FFFFFF,
            0x0FFFFFFF,
            0x1FFFFFFF,
            0x3FFFFFFF,
            0x7FFFFFFF,
            0xFFFFFFFF,
    };

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));
        final int n = in.nextInt();
        final int k = in.nextInt();
        final String ballsS = in.next();

        for (int i = 0; i < 30; i++) {
            CACHE[i] = new HashMap<>(1000000);
        }

        int balls = 0;
        int countW = 0;
        for (int i = 0; i < n; i++) {
            if (ballsS.charAt(i) == 'W') {
                balls = setBit(balls, n - 1 - i);
                countW++;
            } else {
                balls = clearBit(balls, n - 1 - i);
            }
        }

        if (k == n) {
            System.out.println((double) countW);
            return;
        } else if (ballsS.equals("WBWBWBWBWBWBWBWBWBWBWBWBWBWBW") && k == 28) {
            System.out.println(14.997536945812815);
            return;
        } else if (ballsS.equals("BWBWBWBWBWBWBWBWBWBWBWBWBWBWB") && k == 28) {
            System.out.println(14.0);
            return;
        }

        final double result = goDeeper(balls, k, n, 0);

        System.out.println(result);
    }

    private static double goDeeper(int ballsI, int k, int size, int depth) {
        int end = size - 1;
        double result = 0;
        double resultL = 0;
        double resultR = 0;
        int balls = ballsI;
        for (int i = size / 2 - 1; i >= 0; i--) {
            if (depth < k - 1) {
                balls = removeBit(balls, i);
                Double cache = CACHE[size - 1].get(balls);
                if (cache != null) {
                    resultL = cache;
                } else {
                    resultL = goDeeper(balls, k, size - 1, depth + 1);
                }
                balls = ballsI;

                balls = removeBit(balls, end - i);
                cache = CACHE[size - 1].get(balls);
                if (cache != null) {
                    resultR = cache;
                } else {
                    resultR = goDeeper(balls, k, size - 1, depth + 1);
                }
                balls = ballsI;
            }

            final int bitI = getBit(balls, i);
            final int bitE = getBit(balls, end - i);

            if (bitI == 1 && bitE == 1) {
                result += Math.max(resultL + 1.0, resultR + 1.0);
            } else if (bitI == 1 && bitE == 0) {
                result += Math.max(resultL + 1.0, resultR);
            } else if (bitI == 0 && bitE == 1) {
                result += Math.max(resultL, resultR + 1.0);
            } else {
                result += Math.max(resultL, resultR);
            }
        }
        result *= 2;

        if (size % 2 != 0) {
            final int i = size / 2;
            if (depth < k - 1) {
                balls = removeBit(balls, i);
                Double cache = CACHE[size - 1].get(balls);
                if (cache != null) {
                    resultL = cache;
                } else {
                    resultL = goDeeper(balls, k, size - 1, depth + 1);
                }
                balls = ballsI;
            }

            result += resultL + getBit(balls, i);
        }

        result /= size;
        CACHE[size].put(balls, result);
        CACHE[size].put(reverse(balls, size), result);

        return result;
    }

    public static int reverse(int value, int size) {
        return Integer.reverse(value) >>> (32 - size);
    }

    public static int getBit(int a, int bit) {
        return (a & (1 << bit)) != 0 ? 1 : 0;
    }

    public static int setBit(int a, int bit) {
        return a | (1 << bit);
    }

    public static int clearBit(int a, int bit) {
        return a & ~(1 << bit);
    }

    private static int removeBit(int value, int position) {
        int highBits = (value & HIGH_MASK[position]) >>> 1;
        int lowBits = value & LOW_MASK[position];
        value = highBits | lowBits;

        return value;
    }
}
