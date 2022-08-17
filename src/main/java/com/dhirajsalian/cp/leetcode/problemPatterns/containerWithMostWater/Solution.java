// Problem: https://leetcode.com/problems/container-with-most-water/

package com.dhirajsalian.cp.leetcode.problemPatterns.containerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int maxArea = getMaxArea(height, left, right);
        while (left < right) {
            if (height[left] <= height[right]) left++;
            else right--;
            maxArea = Math.max(maxArea, getMaxArea(height, left, right));
        }
        return maxArea;
    }

    int getMaxArea(int[] height, int left, int right) {
        return Math.min(height[left], height[right]) * (right - left);
    }
}
