package hackerrank.java.exception_handling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 23/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-exception-handling-try-catch
 */
public class JavaExceptionHandlingI {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        try {
            System.out.println(in.nextInt() / in.nextInt());
        } catch (InputMismatchException e) {
            System.out.println(e.getClass().getName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
