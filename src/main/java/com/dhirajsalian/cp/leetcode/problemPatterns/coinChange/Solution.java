// Problem: https://leetcode.com/problems/coin-change/

package com.dhirajsalian.cp.leetcode.problemPatterns.coinChange;

import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] change = new int[amount + 1];
        Arrays.fill(change, Integer.MAX_VALUE);
        change[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && change[i - coins[j]] != Integer.MAX_VALUE) {
                    change[i] = Math.min(change[i], 1 + change[i - coins[j]]);
                }
            }
        }
        return change[amount] == Integer.MAX_VALUE ? -1 : change[amount];
    }

    /*
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int minCount = Integer.MAX_VALUE, prevCount;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                prevCount = coinChange(coins, amount - coins[i]);
                if (prevCount != -1)
                    minCount = Math.min(minCount, 1 + prevCount);
            }
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
    */
}
