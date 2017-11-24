package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Aleksandr on 13/11/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w35/challenges/lucky-purchase
 */
public class LuckyPurchase {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();

        final TreeMap<Integer, String> laptops = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            final String name = in.next();
            final String price = in.next();

            boolean isGoodPrice = true;
            int count4 = 0, count7 = 0;
            for (int j = 0; j < price.length(); j++) {
                if (price.charAt(j) == '4') {
                    count4++;
                } else if (price.charAt(j) == '7') {
                    count7++;
                } else {
                    isGoodPrice = false;
                    break;
                }
            }

            if (isGoodPrice && count4 == count7) {
                laptops.put(Integer.parseInt(price), name);
            }
        }

        if (!laptops.isEmpty()) {
            System.out.println(laptops.firstEntry().getValue());
        } else {
            System.out.println(-1);
        }

        in.close();
    }
}
