package hackerrank.tutorial.the_30_days_of_code;

/**
 * Created by Aleksandr on 27/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-dictionaries-and-maps
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class DictionariesAndMaps {
    public static void main(String[] argh) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();
            map.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.next();
            if (map.containsKey(s)) {
                System.out.println(s + "=" + map.get(s));
            } else {
                System.out.println("Not found");
            }
        }
        in.close();
    }
}

