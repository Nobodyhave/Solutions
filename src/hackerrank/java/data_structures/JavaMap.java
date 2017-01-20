package hackerrank.java.data_structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Aleksandr on 19/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/phone-book
 */
public class JavaMap {
    public static void main(String[] argh) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        in.nextLine();
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final String name = in.nextLine();
            final int phone = in.nextInt();
            map.put(name, phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            final String s = in.nextLine();
            final Integer phone = map.get(s);
            if (phone != null) {
                System.out.println(s + "=" + phone);
            } else {
                System.out.println("Not found");
            }
        }
    }
}
