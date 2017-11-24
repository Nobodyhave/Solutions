package leetcode;

/**
 * Created by Aleksandr on 14/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        long T0 = 0, T1 = Integer.MIN_VALUE;

        for (int price : prices) {
            long oldT0 = T0;
            T0 = Math.max(T0, T1 + price - fee);
            T1 = Math.max(T1, oldT0 - price);
        }

        return (int) T0;
    }
}
