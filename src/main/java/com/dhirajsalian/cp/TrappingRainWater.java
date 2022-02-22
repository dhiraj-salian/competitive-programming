package com.dhirajsalian.cp;

/*
Given an array B of non-negative integers. The values in B represent length of bars. The width of bar is 1 unit.
Return the amount of water trapped by the bars.

Examples:

Input 1: B = [ 2, 0, 2 ]
Output 1: 2

Input 2: B = [ 3, 0, 1, 2, 5 ]
Output 2: 6

Input 3: B = [ 1, 2, 3 ]
Output 3: 0

Input 4: B = [ 3, 2, 1 ]
Output 4: 0

Source: geeksforgeeks.org
 */
public class TrappingRainWater {

    static int rainWater(int[] b) {
        int totalWater = 0;
        int[] leftMax = new int[b.length];
        int[] rightMax = new int[b.length];
        leftMax[0] = b[0];
        rightMax[b.length - 1] = b[b.length - 1];
        for (int i = 1; i < b.length; i++) {
            leftMax[i] = Math.max(b[i], leftMax[i - 1]);
        }
        for (int i = b.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(b[i], rightMax[i + 1]);
        }
        for (int i = 1; i < b.length - 1; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - b[i];
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[][] inputs = {{2, 0, 2}, {3, 0, 1, 2, 5}, {1, 2, 3}, {3, 2, 1}};
        for (int[] input : inputs) {
            System.out.println(rainWater(input));
        }
    }
}
