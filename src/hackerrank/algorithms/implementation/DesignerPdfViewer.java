package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 25/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/designer-pdf-viewer
 */

import java.util.Scanner;

public class DesignerPdfViewer {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = 26;
        final int h[] = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }

        final String word = in.next();
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            if (h[c - 'a'] > maxHeight) {
                maxHeight = h[c - 'a'];
            }
        }

        System.out.println(maxHeight * word.length());
    }
}

