package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 03/11/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-24/challenges/strong-password
 */
public class StrongPassword {
    private static final String NUMBERS = "0123456789";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+";

    private static int minimumNumber(int n, String password) {
        boolean hasNumbers = false, hasLower = false, hasUpper = false, hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            final String s = String.valueOf(password.charAt(i));
            if (NUMBERS.contains(s)) {
                hasNumbers = true;
            } else if (LOWER_CASE.contains(s)) {
                hasLower = true;
            } else if (UPPER_CASE.contains(s)) {
                hasUpper = true;
            } else if (SPECIAL_CHARACTERS.contains(s)) {
                hasSpecial = true;
            }
        }

        int toAdd = (hasNumbers ? 0 : 1) + (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasSpecial ? 0 : 1);

        return Math.max(6 - password.length(), toAdd);
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final String password = in.next();

        System.out.println(minimumNumber(n, password));

        in.close();
    }
}
