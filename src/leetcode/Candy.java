package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 29/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/candy
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        } else if (ratings.length == 1) {
            return 1;
        }

        final int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
        }

        int count = 0;
        for (int i = 0; i < candies.length; i++) {
            count += candies[i];
        }

        return count;
    }
}
