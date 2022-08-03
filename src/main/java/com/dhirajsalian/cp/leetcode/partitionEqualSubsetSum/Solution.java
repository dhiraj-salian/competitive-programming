// Problem: https://leetcode.com/problems/partition-equal-subset-sum/

package com.dhirajsalian.cp.leetcode.partitionEqualSubsetSum;

class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) totalSum += nums[i];
        if (totalSum % 2 != 0) return false;
        int requiredSum = totalSum / 2, n = nums.length;
        boolean[][] subsetSum = new boolean[n + 1][requiredSum + 1];
        for (int i = 0; i <= n; i++) subsetSum[i][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= requiredSum; sum++) {
                subsetSum[i][sum] = subsetSum[i - 1][sum];
                if (sum - nums[i - 1] >= 0) subsetSum[i][sum] |= subsetSum[i - 1][sum - nums[i - 1]];
            }
        }
        return subsetSum[n][requiredSum];
    }
}
