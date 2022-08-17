// Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

package com.dhirajsalian.cp.leetcode.problemPatterns.bestTimeToBuyAndSellStockWithCooldown;

class Solution {
    public int maxProfit(int[] prices) {
        int[] profit = new int[prices.length + 1];
        profit[0] = 0;
        for (int i = 1; i <= prices.length; i++) {
            profit[i] = profit[i - 1];
            for (int j = 0; j < i - 1; j++) {
                if (prices[i - 1] - prices[j] > 0)
                    profit[i] = Math.max(profit[i], prices[i - 1] - prices[j]
                            + (j - 1 >= 0 ? profit[j - 1] : 0));
            }
        }
        return profit[prices.length];
    }
}