package hackerrank.algorithms.warmup;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/time-conversion
 */

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeConversion {

    public static void main(String[] args) {
        final String time = new Scanner(System.in).next();
        final LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mm:ssa"));
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
