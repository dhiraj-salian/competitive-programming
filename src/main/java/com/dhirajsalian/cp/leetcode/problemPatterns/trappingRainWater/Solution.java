// Problem: https://leetcode.com/problems/trapping-rain-water/

package com.dhirajsalian.cp.leetcode.problemPatterns.trappingRainWater;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftTop = new int[n], rightTop = new int[n];
        leftTop[0] = height[0];
        rightTop[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftTop[i] = Math.max(leftTop[i - 1], height[i]);
            rightTop[n - i - 1] = Math.max(rightTop[n - i], height[n - i - 1]);
        }
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += (Math.min(leftTop[i], rightTop[i]) - height[i]);
        }
        return totalWater;
    }
}
