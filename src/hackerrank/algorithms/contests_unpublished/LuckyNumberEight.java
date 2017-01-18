package hackerrank.algorithms.contests_unpublished;

import java.io.IOException;
import java.util.*;

/**
 * Created by Aleksandr on 11/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w28/challenges/lucky-number-eight
 */
public class LuckyNumberEight {
    private static final Map<String, Long> COUNTS = new HashMap<>(1200);
    private static final Map<Integer, String> SINGLES = new HashMap<>(10);
    private static final Map<Integer, String> PAIRS = new HashMap<>(100);

    public static void main(String[] args) throws IOException {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final String number = in.next();

        final Map<Integer, List<String>> singles = generateSingles();
        final Map<Integer, List<String>> pairs = generatePairs();
        generateTriplets();

        int countS = 0;
        int countP = 0;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            String str;
            final int num = number.charAt(i) - '0';

            count += count;
            count %= 1000000007;

            if (count < countS) {
                count += 1000000007;
            }
            count -= countS;
            count %= 1000000007;

            if (count < countP) {
                count += 1000000007;
            }
            count -= countP;
            count %= 1000000007;

            for (String s : pairs.get(num)) {
                count += COUNTS.get(s) % 1000000007;
                count %= 1000000007;
            }

            for (String s : singles.get(num)) {
                countP += COUNTS.get(s) % 1000000007;
                countP %= 1000000007;
                count += COUNTS.get(s) % 1000000007;
                count %= 1000000007;
            }

            int num10 = num * 10;
            for (int j = 0; j < 10; j++) {
                final String s = SINGLES.get(j);
                str = PAIRS.get(num10 + j);
                COUNTS.put(str, COUNTS.get(str) + COUNTS.get(s));
            }


            if (num == 8 || num == 0) {
                countS++;
                countS %= 1000000007;
                count++;
                count %= 1000000007;
            }
            str = SINGLES.get(num);
            COUNTS.put(str, COUNTS.get(str) + 1);
        }

        System.out.println(count);
    }

    private static Map<Integer, List<String>> generateSingles() {
        final Map<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                final String s = String.valueOf(j);
                if ((i * 10 + j) % 8 == 0) {
                    List<String> nums = map.get(i);
                    if (nums == null) {
                        nums = new ArrayList<>();
                        map.put(i, nums);
                    }
                    nums.add(s);
                }
                COUNTS.put(s, 0L);
                SINGLES.put(j, s);
            }
        }

        return map;
    }

    private static Map<Integer, List<String>> generatePairs() {
        final Map<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(j).append(k);
                    final String s = sb.toString();
                    if ((i * 100 + j * 10 + k) % 8 == 0) {

                        List<String> nums = map.get(i);
                        if (nums == null) {
                            nums = new ArrayList<>();
                            map.put(i, nums);
                        }
                        nums.add(s);
                    }
                    COUNTS.put(s, 0L);
                    PAIRS.put(j * 10 + k, s);
                }
            }
        }

        return map;
    }

    private static void generateTriplets() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(i).append(j).append(k);
                    final String s = sb.toString();
                    COUNTS.put(s, 0L);
                }
            }
        }
    }
}
