// Problem: https://leetcode.com/problems/longest-increasing-subsequence/

package com.dhirajsalian.cp.leetcode.problemPatterns.longestIncreasingSubsequence;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int maxLis = 0;
        for (int i = 0; i < nums.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) lis[i] = Math.max(lis[i], lis[j] + 1);
            }
            maxLis = Math.max(maxLis, lis[i]);
        }
        return maxLis;
    }
}
