// Problem: https://leetcode.com/problems/number-of-longest-increasing-subsequence/

package com.dhirajsalian.cp.leetcode.numberOfLongestIncreasingSubsequence;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int[] count = new int[nums.length];
        int maxLis = 0;
        for (int i = 0; i < nums.length; i++) {
            lis[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lis[j] + 1 > lis[i]) {
                        lis[i] = lis[j] + 1;
                        count[i] = count[j];
                    } else if (lis[j] + 1 == lis[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLis = Math.max(maxLis, lis[i]);
        }
        int totalCount = 0;
        for (int i = 0; i < nums.length; i++) {
            totalCount += (lis[i] == maxLis ? count[i] : 0);
        }
        return totalCount;
    }
}
