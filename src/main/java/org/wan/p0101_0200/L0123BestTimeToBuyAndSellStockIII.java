package org.wan.p0101_0200;

public class L0123BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int dp_1_0 = 0,  dp_1_1 = Integer.MIN_VALUE;
        int dp_2_0 = 0,   dp_2_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_1_0 = Math.max(dp_1_0, dp_1_1 + prices[i]);
            dp_1_1 = Math.max(dp_1_1, -prices[i]);
            dp_2_0 = Math.max(dp_2_0, dp_2_1 + prices[i]);
            dp_2_1 = Math.max(dp_2_1, dp_1_0 - prices[i]);
        }
        return dp_2_0;
    }
}
