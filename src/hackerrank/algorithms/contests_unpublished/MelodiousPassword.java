package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 15/03/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w30/challenges/melodious-password
 */
public class MelodiousPassword {
    private static char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
    private static char[] CONSONANTS = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int N = in.nextInt();

        final StringBuilder passwords = new StringBuilder();
        goDeeper(passwords, new StringBuilder(), 0, N);

        System.out.println(passwords.toString());
    }

    private static void goDeeper(StringBuilder passwords, StringBuilder sb, int count, int N) {
        if (count >= N) {
            passwords.append(sb).append('\n');
            return;
        }

        if (count == 0) {
            for (Character c : VOWELS) {
                sb.append(c);
                goDeeper(passwords, sb, count + 1, N);
                sb.deleteCharAt(sb.length() - 1);
            }
            for (Character c : CONSONANTS) {
                sb.append(c);
                goDeeper(passwords, sb, count + 1, N);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            final char lastChar = sb.charAt(sb.length() - 1);
            if (lastChar == 'a' || lastChar == 'e' || lastChar == 'i' || lastChar == 'o' || lastChar == 'u') {
                for (Character c : CONSONANTS) {
                    sb.append(c);
                    goDeeper(passwords, sb, count + 1, N);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                for (Character c : VOWELS) {
                    sb.append(c);
                    goDeeper(passwords, sb, count + 1, N);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
