package hackerrank.java.introduction;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-currency-formatter
 */
public class JavaCurrencyFormatter {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final double payment = scanner.nextDouble();
        scanner.close();

        final NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        final NumberFormat india = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        final NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        final NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println("US: " + us.format(payment));
        System.out.println("India: " + india.format(payment));
        System.out.println("China: " + china.format(payment));
        System.out.println("France: " + france.format(payment));
    }
}
