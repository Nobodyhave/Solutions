package hackerrank.algorithms.bit_manipulation;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 16/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/aorb
 */
public class AorB {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            int K = in.nextInt();
            StringBuilder Ap = new StringBuilder(hex2binary(in.next()));
            StringBuilder Bp = new StringBuilder(hex2binary(in.next()));
            String C = hex2binary(in.next());

            final int maxLength = Math.max(Ap.length(), Math.max(Bp.length(), C.length()));


            if (Ap.length() < maxLength) {
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < maxLength - Ap.length(); i++) {
                    sb.append(0);
                }
                Ap = sb.append(Ap);
            }
            if (Bp.length() < maxLength) {
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < maxLength - Bp.length(); i++) {
                    sb.append(0);
                }
                Bp = sb.append(Bp);
            }

            if (C.length() < maxLength) {
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < maxLength - C.length(); i++) {
                    sb.append(0);
                }
                C = sb.toString() + C;
            }

            for (int i = 0; i < C.length(); i++) {
                if (C.charAt(i) == '1') {
                    if (Ap.charAt(i) == '1' && Bp.charAt(i) == '1') {
                        // No need to change now
                    } else if (Ap.charAt(i) == '1' || Bp.charAt(i) == '1') {
                        // No need to change now
                    } else {
                        Bp.setCharAt(i, '1');
                        K--;
                    }
                } else {
                    if (Ap.charAt(i) == '1' && Bp.charAt(i) == '1') {
                        Ap.setCharAt(i, '0');
                        Bp.setCharAt(i, '0');
                        K -= 2;
                    } else if (Ap.charAt(i) == '1') {
                        Ap.setCharAt(i, '0');
                        K--;
                    } else if (Bp.charAt(i) == '1') {
                        Bp.setCharAt(i, '0');
                        K--;
                    } else {
                        // No need to change now
                    }
                }

                if (K < 0) {
                    break;
                }
            }

            if (K < 0) {
                System.out.println(-1);
                continue;
            } else if (K == 0) {
                System.out.println(new BigInteger(Ap.toString(), 2).toString(16).toUpperCase());
                System.out.println(new BigInteger(Bp.toString(), 2).toString(16).toUpperCase());
                continue;
            }

            for (int i = 0; i < C.length(); i++) {
                if (C.charAt(i) == '1') {
                    if (Ap.charAt(i) == '1' && Bp.charAt(i) == '1') {
                        Ap.setCharAt(i, '0');
                        K--;
                    } else if (Ap.charAt(i) == '1') {
                        if (K > 1) {
                            Ap.setCharAt(i, '0');
                            Bp.setCharAt(i, '1');
                            K -= 2;
                        }
                    } else {
                        // No need to change now
                    }
                }

                if (K == 0) {
                    break;
                }
            }

            System.out.println(new BigInteger(Ap.toString(), 2).toString(16).toUpperCase());
            System.out.println(new BigInteger(Bp.toString(), 2).toString(16).toUpperCase());
        }
    }

    private static String hex2binary(String hex) {
        StringBuilder result = new StringBuilder(hex.length() * 4);
        for (int i = 0; i < hex.length(); i++) {
            switch (hex.charAt(i)) {
                case '0':
                    result.append("0000");
                    break;
                case '1':
                    result.append("0001");
                    break;
                case '2':
                    result.append("0010");
                    break;
                case '3':
                    result.append("0011");
                    break;
                case '4':
                    result.append("0100");
                    break;
                case '5':
                    result.append("0101");
                    break;
                case '6':
                    result.append("0110");
                    break;
                case '7':
                    result.append("0111");
                    break;
                case '8':
                    result.append("1000");
                    break;
                case '9':
                    result.append("1001");
                    break;
                case 'A':
                    result.append("1010");
                    break;
                case 'B':
                    result.append("1011");
                    break;
                case 'C':
                    result.append("1100");
                    break;
                case 'D':
                    result.append("1101");
                    break;
                case 'E':
                    result.append("1110");
                    break;
                case 'F':
                    result.append("1111");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid hex: '" + hex + "'");
            }
        }
        return result.toString();
    }
}
