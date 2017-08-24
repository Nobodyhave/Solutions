package leetcode;

/**
 * Created by Aleksandr on 16/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        final int[] state0 = new int[prices.length];
        final int[] state1 = new int[prices.length];
        final int[] state2 = new int[prices.length];

        state0[0] = 0;
        state1[0] = -prices[0];
        state2[0] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            state0[i] = Math.max(state0[i - 1], state2[i - 1]);
            state1[i] = Math.max(state1[i - 1], state0[i - 1] - prices[i]);
            state2[i] = state1[i - 1] + prices[i];
        }

        return Math.max(state0[prices.length - 1], state2[prices.length - 1]);
    }
}
