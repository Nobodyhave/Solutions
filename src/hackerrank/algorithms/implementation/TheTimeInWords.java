package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/the-time-in-words
 */
public class TheTimeInWords {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int hours = in.nextInt();
        final int minutes = in.nextInt();

        String str = "";
        if (minutes == 0) {
            str += convert(hours) + " o' clock";
        } else if (minutes == 15) {
            str += "quarter past" + convert(hours);
        } else if (minutes == 30) {
            str += "half past" + convert(hours);
        } else if (minutes == 45) {
            str += "quarter to" + convert(hours + 1);
        } else if (minutes == 1) {
            str += convert(minutes) + " minute past" + convert(hours);
        } else if (minutes < 30) {
            str += convert(minutes) + " minutes past" + convert(hours);
        } else if (minutes > 30) {
            str += convert(60 - minutes) + " minutes to" + convert(hours + 1);
        }

        System.out.println(str.trim());
    }

    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    private static String convert(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " hundred" + soFar;
    }
}
