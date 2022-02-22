package com.dhirajsalian.cp;

/*
Given an array S, which represents the stock prices in a given day. We can buy the stock in any day and sell
the stock in any day. We need to maximise the profit.

Examples:

Input 1: S = [ 1, 5, 3, 8, 12 ]
Output 1: 13

Input 2: S = [ 30, 20, 10 ]
Output 2: 0

Input 3: S = [ 10, 20, 30 ]
Output 3: 20

Input 4: S = [ 1, 5, 3, 1, 2, 8 ]
Output 4: 11

Source: geeksforgeeks.org
 */
public class StockBuyAndSell {

    static int maxProfit(int[] s) {
        int profit = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[i] > s[i - 1]) {
                profit += (s[i] - s[i - 1]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[][] inputs = {{1, 5, 3, 8, 12}, {30, 20, 10}, {10, 20, 30}, {1, 5, 3, 1, 2, 8}};
        for (int[] input : inputs) {
            System.out.println(maxProfit(input));
        }
    }
}
