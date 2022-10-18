// Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package com.dhirajsalian.cp.leetcode.problemPatterns.bestTimeToBuyAndSellStock;

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i]-min);
        }
        return profit;
    }
}
