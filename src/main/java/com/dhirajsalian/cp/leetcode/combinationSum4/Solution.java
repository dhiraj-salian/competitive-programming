// Problem: https://leetcode.com/problems/combination-sum-iv/

package com.dhirajsalian.cp.leetcode.combinationSum4;

class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] sum = new int[target + 1];
        sum[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0)
                    sum[i] += sum[i - nums[j]];
            }
        }
        return sum[target];
    }

    /*public int combinationSum4(int[] nums, int target) {
        if (target == 0)
            return 1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0)
                ans += combinationSum4(nums, target - nums[i]);
        }
        return ans;
    }*/
}
