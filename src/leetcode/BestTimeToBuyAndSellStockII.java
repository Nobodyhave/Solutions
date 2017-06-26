package leetcode;

/**
 * Created by Aleksandr on 26/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }

        int i = 0, profit = 0;
        while(true) {
            while(i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            int minIndex = i;

            while(i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            int maxIndex = i;

            if(i + 1 == prices.length) {
                if(prices[i-1] <= prices[i]) {
                    profit += prices[i] - prices[minIndex];
                }
                break;
            } else if(i + 1 > prices.length) {
                break;
            } else {
                profit += prices[maxIndex] - prices[minIndex];
            }
        }

        return profit;
    }
}
