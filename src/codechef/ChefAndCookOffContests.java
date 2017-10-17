package codechef;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Aleksandr on 09/10/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/LTIME52/problems/C00K0FF
 */
public class ChefAndCookOffContests {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                final String difficulty = in.next();
                map.put(difficulty, 1);
            }
            if (map.containsKey("cakewalk")
                    && map.containsKey("simple")
                    && map.containsKey("easy")
                    && (map.containsKey("easy-medium") || map.containsKey("medium"))
                    && (map.containsKey("medium-hard") || map.containsKey("hard"))) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
