package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aleksandr on 18/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/shopping-offers
 */
public class ShoppingOffers {
    private final Map<String, Integer> CACHE = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    private int dfs(List<Integer> price, List<List<Integer>> specials, List<Integer> needs) {
        if (needsSatisfied(needs)) {
            return 0;
        }

        final String key = getKey(needs);
        if (CACHE.containsKey(key)) {
            return CACHE.get(key);
        }

        int min = Integer.MAX_VALUE;
        for (List<Integer> special : specials) {
            int count = 0;
            do {
                decrementNeeds(needs, special);
                count++;
            } while (needsValid(needs));

            incrementNeeds(needs, special);
            count--;

            if (count > 0) {
                min = Math.min(min, dfs(price, specials, needs) + special.get(special.size() - 1) * count);
            }
            while (count > 0) {
                incrementNeeds(needs, special);
                count--;
            }
        }

        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) > 0) {
                int oldNeed = needs.get(i);
                needs.set(i, 0);
                min = Math.min(min, dfs(price, specials, needs) + price.get(i) * oldNeed);
                needs.set(i, oldNeed);
            }
        }

        CACHE.put(key, min);

        return min;
    }

    private String getKey(List<Integer> needs) {
        final StringBuilder sb = new StringBuilder();
        for (Integer need : needs) {
            sb.append(need);
        }

        return sb.toString();
    }

    private void decrementNeeds(List<Integer> needs, List<Integer> special) {
        for (int i = 0; i < needs.size(); i++) {
            needs.set(i, needs.get(i) - special.get(i));
        }
    }

    private void incrementNeeds(List<Integer> needs, List<Integer> special) {
        for (int i = 0; i < needs.size(); i++) {
            needs.set(i, needs.get(i) + special.get(i));
        }
    }

    private boolean needsValid(List<Integer> needs) {
        for (Integer need : needs) {
            if (need < 0) {
                return false;
            }
        }

        return true;
    }

    private boolean needsSatisfied(List<Integer> needs) {
        for (Integer need : needs) {
            if (need != 0) {
                return false;
            }
        }

        return true;
    }
}
