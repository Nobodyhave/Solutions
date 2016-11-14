package hackerrank.algorithms.implementation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 14/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/matrix-rotation-algo
 */
public class MatrixLayerRotation {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int M = in.nextInt();
        final int N = in.nextInt();
        final int R = in.nextInt();

        final int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        rotateMatrix(matrix, R);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void rotateMatrix(int[][] matrix, int R) {
        final int layers = Math.min(matrix.length, matrix[0].length) / 2;

        for (int layer = 0; layer < layers; layer++) {
            final int layerHeight = matrix.length - 2 * layer;
            final int layerWidth = matrix[0].length - 2 * layer;
            final int steps = R % (layerHeight * 2 + (layerWidth - 2) * 2);

            rotateLayer(matrix, layer, layerHeight, layerWidth, steps);
        }
    }

    private static void rotateLayer(int[][] matrix, int layer, int height, int width, int steps) {
        final int[] a = new int[height * 2 + (width-2) * 2];

        int count = 0;
        for (int i = layer; i < layer + height; i++, count++) {
            a[count] = matrix[i][layer];
        }

        for (int i = layer + 1; i < layer + width - 1; i++, count++) {
            a[count] = matrix[layer + height - 1][i];
        }

        for (int i = layer + height - 1; i >= layer; i--, count++) {
            a[count] = matrix[i][layer + width - 1];
        }

        for (int i = layer + width - 2; i > layer; i--, count++) {
            a[count] = matrix[layer][i];
        }

        rotateArray(a, steps);

        count = 0;
        for (int i = layer; i < layer + height; i++, count++) {
            matrix[i][layer] = a[count];
        }

        for (int i = layer + 1; i < layer + width - 1; i++, count++) {
            matrix[layer + height - 1][i] = a[count];
        }

        for (int i = layer + height - 1; i >= layer; i--, count++) {
            matrix[i][layer + width - 1] = a[count];
        }

        for (int i = layer + width - 2; i > layer; i--, count++) {
            matrix[layer][i] = a[count];
        }
    }

    private static void rotateArray(int[] a, int steps) {
        final int border = (a.length - 1) - steps;

        reverseArray(a, 0, border);
        reverseArray(a, border+1, a.length - 1);
        reverseArray(a, 0, a.length - 1);
    }

    private static void reverseArray(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

}
