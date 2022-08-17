// Problem: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

package com.dhirajsalian.cp.leetcode.problemPatterns.partitionToKEqualSumSubsets;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Integer, Boolean> mem = new HashMap<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        return canPartition(nums, k, 0, 0, sum / k, 0);
    }

    public boolean canPartition(int[] nums, int k, int currentSum, int start, int targetSum, int used) {
        if (k == 1) {
            return true;
        }
        if (currentSum == targetSum) {
            boolean res = canPartition(nums, k - 1, 0, 0, targetSum, used);
            mem.put(used, res);
            return res;
        }
        if (mem.containsKey(used)) return mem.get(used);
        for (int i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1) continue;
            if (currentSum + nums[i] > targetSum) continue;
            used |= (1 << i);
            if (canPartition(nums, k, currentSum + nums[i], i + 1, targetSum, used)) return true;
            used ^= (1 << i);
        }
        return false;
    }
}