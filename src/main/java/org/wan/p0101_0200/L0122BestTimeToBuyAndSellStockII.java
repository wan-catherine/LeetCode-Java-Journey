package org.wan.p0101_0200;

import java.util.ArrayList;
import java.util.List;

public class L0122BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        List<Integer> list = new ArrayList<>();
        int maxProfit = 0;
        for (int i = 0; i <= prices.length - 1; i++) {
            if (list.size() > 0 && prices[i] < list.getLast()) {
                int base = list.removeLast();
                while (list.size() > 0) {
                    maxProfit += base - list.getLast();
                    base = list.removeLast();
                }
            }
            list.add(prices[i]);
        }
        if (list.size() > 1) {
            int base = list.removeLast();
            while (list.size() > 0) {
                maxProfit += base - list.getLast();
                base = list.removeLast();
            }
        }
        return maxProfit;
    }
}
