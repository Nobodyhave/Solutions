package leetcode;

/**
 * Created by Aleksandr on 26/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        final int[] min = new int[prices.length];
        min[0] = prices[0];
        for(int i = 1; i < prices.length; i++) {
            min[i] = Math.min(min[i-1], prices[i]);
        }

        int bestProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            final int profit = prices[i] - min[i];
            if(profit > bestProfit) {
                bestProfit = profit;
            }
        }

        return bestProfit;
    }
}
