package hackerrank.java.introduction;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-date-and-time
 */
public class JavaDateAndTime {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final String month = in.next();
        final String day = in.next();
        final String year = in.next();

        final Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));

        System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()).toUpperCase());
    }
}
