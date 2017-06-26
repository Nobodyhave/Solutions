package leetcode;

/**
 * Created by Aleksandr on 26/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        final int n = prices.length;

        final int[] min = new int[n];
        min[0] = prices[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], prices[i]);
        }
        final int[] max = new int[n];
        max[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], prices[i]);
        }

        final int[] profitLeft = new int[n];
        profitLeft[0] = 0;
        for (int i = 1; i < n; i++) {
            profitLeft[i] = Math.max(profitLeft[i - 1], prices[i] - min[i]);
        }
        final int[] profitRight = new int[n];
        profitRight[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            profitRight[i] = Math.max(profitRight[i + 1], max[i] - prices[i]);
        }

        int bestProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            final int profit = maxProfit(profitLeft, profitRight, i);

            if (profit > bestProfit) {
                bestProfit = profit;
            }
        }

        return bestProfit;
    }

    private static int maxProfit(int[] profitLeft, int[] profitRight, int i) {
        if (i == 0) {
            return profitRight[i];
        } else if (i == profitLeft.length - 1) {
            return profitLeft[i];
        } else {
            return profitLeft[i - 1] + profitRight[i];
        }
    }
}
