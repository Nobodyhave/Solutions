package leetcode;

/**
 * Created by Aleksandr on 26/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k == 0) {
            return 0;
        } else if (k >= prices.length / 2) {
            return maxProfit(prices);
        }

        final int[] holdStock = new int[k + 1];
        final int[] releaseStock = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            holdStock[i] = Integer.MIN_VALUE;
            releaseStock[i] = 0;
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {
                releaseStock[j] = Math.max(holdStock[j] + prices[i], releaseStock[j]);
                holdStock[j] = Math.max(holdStock[j], releaseStock[j - 1] - prices[i]);
            }
        }

        return releaseStock[k];
    }

    private static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(prices[i] - prices[i - 1], 0);
        }

        return profit;
    }
}
